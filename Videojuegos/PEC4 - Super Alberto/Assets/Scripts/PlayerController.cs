using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class PlayerController : MonoBehaviour
{
    
    public static PlayerController sharedInstance;
    public float velocidad = 2.5f;
    public float fuerzaSalto = 2.5f;

    private Rigidbody2D rb;
    private Animator animator;

    private Vector2 movimiento;
    private bool mirarDerecha = true;
    private bool enSuelo = true;

    public Transform sueloCheck;
    public LayerMask sueloLayer;
    public float radioSuelo;
    //Muere
    public bool playerMuerto;
    
    //Ataque
    private bool esAtaque = false;

    //Puntuacion
    private Vector3 startPosition;
    
    //SONIDO DE SALTO
    private AudioSource SonidoDeSalto;
    private void Awake()
    {
        sharedInstance = this;
        rb = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();
        startPosition = this.transform.position;
    }

    // Start is called before the first frame update
    void Start()
    {
        playerMuerto = false;
    }

    // Update is called once per frame
    void Update()
    {
        if (esAtaque == false)
        {
            //Con Raw da o -1 o 1, sin demora
            float horizontalInput = Input.GetAxisRaw("Horizontal");
            movimiento = new Vector2(horizontalInput, 0f);
        
            //Girar personaje
            if (horizontalInput < 0f && mirarDerecha == true)
            {
                Flip();
            }
            else if (horizontalInput > 0f && mirarDerecha == false)
            {
                Flip();
            }
        }
        
        //Se cae al agua
        if (transform.position.y < -4)
        {
            Morir();
        }
        
        
        //Esta en el suelo?
        enSuelo = Physics2D.OverlapCircle(sueloCheck.position, radioSuelo, sueloLayer);
        //Salto
        if (Input.GetKeyDown(KeyCode.Space ) && enSuelo == true && esAtaque == false)
        {
            rb.AddForce(Vector2.up * fuerzaSalto, ForceMode2D.Impulse);
            SonidoDeSalto.Play();
        }
        
        //Ataque
        if (Input.GetKeyDown(KeyCode.Tab) && enSuelo == true && esAtaque == false)
        {
            movimiento = Vector2.zero;
            rb.velocity = Vector2.zero;
            animator.SetTrigger("Attack");
            
        }

    }

    private void FixedUpdate()
    {
        if (esAtaque == false)
        {
            float horizontalVelocidad = movimiento.normalized.x * velocidad;
            rb.velocity = new Vector2(horizontalVelocidad, rb.velocity.y); 
        }
        
    }

    //Justo antes de dibujar en pantalla lo que pase, to_do relacionado con animaciones aqui:
    private void LateUpdate()
    {
        animator.SetBool("Idle", movimiento == Vector2.zero);
        animator.SetBool("enSuelo", enSuelo);
        animator.SetFloat("velY", rb.velocity.y);
        
        // Animator
        if (animator.GetCurrentAnimatorStateInfo(0).IsTag("Attack"))
        {
            esAtaque = true;
        }
        else
        {
            esAtaque = false;
        }
    }

    private void Flip()
    {
        mirarDerecha = !mirarDerecha;
        float localScaleX = transform.localScale.x;
        localScaleX = localScaleX * -1f;
        transform.localScale = new Vector3(localScaleX, transform.localScale.y, transform.localScale.z );
    }

    public float ObtenerDistance()
    {
        float distanciaMovida = Vector2.Distance(new Vector2(startPosition.x, 0), new Vector2(this.transform.position.x, 0) );

        return distanciaMovida;
    }

    public void Morir()
    {
        //¿Máxima puntuacion?
        float actualMaxScore = PlayerPrefs.GetFloat("maxscore", 0);
        if (actualMaxScore < this.ObtenerDistance())
        {
            //Tenemos Record
            PlayerPrefs.SetFloat("maxscore", this.ObtenerDistance());
        }
        //Player muere
        playerMuerto = true;
        //animator.SetBool("playerMuerto", true );
        GetComponent<Rigidbody2D>().AddForce(Vector2.up*200);
        Invoke("EliminarPlayer",1f);
        
        
    }
    void EliminarPlayer()
    {
        gameObject.SetActive(false);
        SceneManager.LoadScene("MenuFinal");
    }

    private void OnCollisionEnter2D(Collision2D other)
    {
        if (other.gameObject.name == "Enemy")
        {
            Morir();
        }
        if (other.gameObject.tag == "Diamante2")
        {
            SceneManager.LoadScene("MenuExito");
        }
        if (other.gameObject.tag == "Diamante1")
        {
            SceneManager.LoadScene("Land2");
        }
    }
}

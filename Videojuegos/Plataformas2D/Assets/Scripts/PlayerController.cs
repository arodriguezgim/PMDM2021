using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    //Velocidad del jugador
    public float speed = 2.5f;

    
    public Transform groundCheck; // Será desde donde chequearemos el suelo
    public LayerMask groundLayer; // Nos permitirá seleccionar la Layer del Suelo
    public float groundCheckRadious; // Cómo será de grande nuestro groundcheker

    //Referencias
    private Rigidbody2D _rigidbody;
    private Animator _animator;

    // Movimiento
    private Vector2 _movement;
    private bool _facingRight = true;
    private bool _enSuelo; //Me dirá si estoy o no en el suelo

    void Awake()
    {
        //Cogemos la referencia
        _rigidbody = GetComponent<Rigidbody2D>();
        _animator = GetComponent<Animator>();
    }

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update es el sitio idoneo para coger el Input del jugador
    void Update()
    {
        // Solo usaremos izquierda y derecha en el joystick
        float horizontalInput = Input.GetAxisRaw("Horizontal");
        _movement = new Vector2(horizontalInput, 0f);

        // Voltear el Player
        if ( horizontalInput < 0f && _facingRight == true)
        {
            Flip();
        } else if ( horizontalInput > 0f && _facingRight == false)
        {
            Flip();
        }

        // estamos en el Suelo????
        _enSuelo = Physics2D.OverlapCircle(groundCheck.position, groundCheckRadious, groundLayer);
    }

    //FixedUpdate es el metodo idoneo para mover cualquier objeto físico
    void FixedUpdate()
    {
        float horizontalVelocity = _movement.normalized.x * speed;
        _rigidbody.velocity = new Vector2(horizontalVelocity, _rigidbody.velocity.y);
    }
    // LateUpdate es el metodo donde conviene controlar todas las animaciones
    void LateUpdate()
    {
        _animator.SetBool("Idle", _movement == Vector2.zero);  
    }

    private void Flip()
    {
        _facingRight = !_facingRight;
        float localScaleX = transform.localScale.x;
        localScaleX = localScaleX * -1f;
        transform.localScale = new Vector3(localScaleX, transform.localScale.y, transform.localScale.z);
    }

}

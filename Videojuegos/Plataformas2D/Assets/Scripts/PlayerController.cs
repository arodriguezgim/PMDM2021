using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    public float longTimeIdle = 5f;
    //Velocidad del jugador
    public float speed = 2.5f;
    public float jumpForce = 2.5f;

    
    public Transform groundCheck; // Será desde donde chequearemos el suelo
    public LayerMask groundLayer; // Nos permitirá seleccionar la Layer del Suelo
    public float groundCheckRadious; // Cómo será de grande nuestro groundcheker

    //Referencias
    private Rigidbody2D _rigidbody;
    private Animator _animator;

    // Long Idle
    private float _longIdleTimer; //Contador de tiempo

    // Movimiento
    private Vector2 _movement;
    private bool _facingRight = true;
    private bool _enSuelo; //Me dirá si estoy o no en el suelo

    // Ataque
    private bool _isAttacking; // Necesito saber cuando ataca para no atacar cuando se esté atacando.

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

        // estamos saltando?
        if ( Input.GetButtonDown("Jump") && _enSuelo == true && _isAttacking == false)
        {
            _rigidbody.AddForce(Vector2.up * jumpForce, ForceMode2D.Impulse);
        }

        // Estamos Atacando?
        if ( Input.GetButtonDown("Fire1") && _enSuelo == true && _isAttacking == false)
        {
            _movement = Vector2.zero; // Detengo al personaje
            _rigidbody.velocity = Vector2.zero;
            _animator.SetTrigger("Attack");
        }
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
        _animator.SetBool("isGrounded", _enSuelo);
        _animator.SetFloat("VerticalVelocity", _rigidbody.velocity.y);

        // Animator
        // Me devuelve el estado actual, y le pregunto si estoy atacando
        if (_animator.GetCurrentAnimatorStateInfo(0).IsTag("Attack"))
        {
            _isAttacking = true;
        } else
        {
            _isAttacking = false;
        }

        // Long Idle
        if ( _animator.GetCurrentAnimatorStateInfo(0).IsTag("Idle"))
        {
            _longIdleTimer += Time.deltaTime;
            if (_longIdleTimer >= longTimeIdle)
            {
                _animator.SetTrigger("LongIdle");
            } 
        }
        else
        {
            _longIdleTimer = 0f;
        }
    }

    private void Flip()
    {
        _facingRight = !_facingRight;
        float localScaleX = transform.localScale.x;
        localScaleX = localScaleX * -1f;
        transform.localScale = new Vector3(localScaleX, transform.localScale.y, transform.localScale.z);
    }

}

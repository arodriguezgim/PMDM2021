

# 3.3. Entrada del jugador

Vamos a añadirle comportamiento al motorista para que responda a nuestra
interacción. Lo que queremos es tener cuatro acciones distintas:
acelerar, frenar, elevar la rueda trasera (*wheelie*) y elevar la rueda
trasera (*stoppie*). Programaremos estas funciones en un *script* que
llamaremos BikeController:

```csharp
using UnityEngine;

public class BikeController : MonoBehaviour
{
    public float LinearSpeed = 1;
    public float RotationSpeed = 50;

    private Rigidbody2D rb;

    private void Awake()
    {
        rb = GetComponent<Rigidbody2D>();
    }
    
    private void Update()
    {
        if (Input.GetKey(KeyCode.LeftArrow))
        {
            MoveBackward();
        }

        if (Input.GetKey(KeyCode.RightArrow))
        {
            MoveForward();
        }

        if (Input.GetKey(KeyCode.UpArrow))
        {
            DoStoppie();
        }

        if (Input.GetKey(KeyCode.DownArrow))
        {
            DoWheelie();
        }
    }

    private void MoveForward()
    {
        var right = transform.right;
        rb.velocity += new Vector2(right.x * LinearSpeed, right.y * LinearSpeed) * Time.deltaTime;
    }

    private void MoveBackward()
    {
        var right = transform.right;
        rb.velocity -= new Vector2(right.x * LinearSpeed, right.y * LinearSpeed) * Time.deltaTime;
    }

    private void DoWheelie()
    {
        rb.MoveRotation(rb.rotation + RotationSpeed * Time.deltaTime);
    }

    private void DoStoppie()
    {
        rb.MoveRotation(rb.rotation - RotationSpeed * Time.deltaTime);
    }
}
```

Algunos puntos de interés sobre este código:

-   Utilizamos el método *Awake* para cachear el componente
    Rigidbody2D en una variable y no incurrir en llamadas innecesarias
    a GetComponent.

-   Utilizamos *if* en lugar de *if/else* para permitir que el jugador
    pulse varias teclas al mismo tiempo.

Con este *script*, ya podemos controlar al motorista si lo añadimos al
GameObject correspondiente. Pero aún nos quedan algunas cuestiones por
refinar. Por ejemplo, no detectamos si el motorista se ha dado la vuelta
o no, y tampoco controlamos si estamos tocando el suelo para acelerar
(para este juego nos puede interesar hacer esta comprobación ya que le
añade dificultad). Podemos añadir esta funcionalidad en el mismo
*script*:

```csharp
using System;
using UnityEngine;

public class BikeController : MonoBehaviour
{
    public float LinearSpeed = 1;
    public float RotationSpeed = 50;

    public Transform BackWheel;

    public Action OnKilled;

    private Rigidbody2D rb;
    private float wheelRadius;

    private void Awake()
    {
        rb = GetComponent<Rigidbody2D>();
        wheelRadius = GetComponent<CircleCollider2D>().radius;
    }

    private void Update()
    {
        if (Input.GetKey(KeyCode.LeftArrow))
        {
            MoveBackward();
        }

        if (Input.GetKey(KeyCode.RightArrow))
        {
            MoveForward();
        }

        if (Input.GetKey(KeyCode.UpArrow))
        {
            DoStoppie();
        }

        if (Input.GetKey(KeyCode.DownArrow))
        {
            DoWheelie();
        }
    }

    private void MoveForward()
    {
        if (IsGrounded())
        {
            var right = transform.right;
            rb.velocity += new Vector2(right.x * LinearSpeed, right.y * LinearSpeed) * Time.deltaTime;
        }
    }

    private void MoveBackward()
    {
        if (IsGrounded())
        {
            var right = transform.right;
            rb.velocity -= new Vector2(right.x * LinearSpeed, right.y * LinearSpeed) * Time.deltaTime;
        }
    }

    private void DoWheelie()
    {
        rb.MoveRotation(rb.rotation + RotationSpeed * Time.deltaTime);
    }

    private void DoStoppie()
    {
        rb.MoveRotation(rb.rotation - RotationSpeed * Time.deltaTime);
    }

    private bool IsGrounded()
    {
        return Physics2D.OverlapCircleAll(BackWheel.position, wheelRadius * 1.1f).Length > 1;
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.gameObject != gameObject)
            OnKilled?.Invoke();
    }
}
```

Como vemos, hemos incluido un delegado, OnKilled, que se llamará cuando
detectemos que el motorista se ha dado la vuelta. Esto lo logramos
marcando el BoxCollider2D como Is Trigger, que nos hará una llamada a
OnTriggerEnter2D cuando detecte una colisión. También hemos añadido la
función IsGrounded, que comprueba si la rueda trasera está tocando el
suelo o no. Para que funcione, en el editor debemos crear un GameObject
hijo del motorista, moverlo al centro de la rueda y asignarlo al
parámetro BackWheel:

![](images/part3/back_wheel.png)

Con la entrada funcionando, podemos empezar a diseñar un nivel y
añadirle elementos de juego.


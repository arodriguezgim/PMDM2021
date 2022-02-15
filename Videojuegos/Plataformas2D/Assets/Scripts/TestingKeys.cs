using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TestingKeys : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        // 1- Eventos de Raton
        if ( Input.GetMouseButtonDown(0))
        {
            Debug.Log("Nosotros podemos usar esto para iniciar un ataque, esto es llamado una sola vez");
        }
        if (Input.GetMouseButton(0))
        {
            Debug.Log("GetMouseButton");
        }
        if (Input.GetMouseButtonUp(0))
        {
            Debug.Log("GetMouseButtonDown");
        }
        //2 - Eventos de teclado
        //if (Input.GetKeyDown(KeyCode.Space))
        //{
          //  Debug.Log("Salta");
        //}
        // 2.1 Recuerda que podemos usar las funciones GetKey GetKeyDown, etc pero Unity NO LAS RECOMIENDA
        if (Input.GetButtonDown("Jump"))
        {
            Debug.Log("Salto con Jump");
        }

        // 3 - Obtener axis para el movimiento
        // Valores que van entre -1f a 1f
        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");
         if ( horizontal < 0f || horizontal > 0f)
        {
            Debug.Log("Axis Horizontal es " + horizontal);
        }
        if (vertical < 0f || vertical > 0f)
        {
            Debug.Log("Axis Vertical es " + vertical);
        }

    }
}

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bala : MonoBehaviour
{
    public float velocidad = 2f;
    public Vector2 direccion;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        //Como quiero que mi magnitud sea uno lo normalizo
        Vector2 movimiento = direccion.normalized * velocidad * Time.deltaTime;
        transform.Translate(movimiento);
    }
}

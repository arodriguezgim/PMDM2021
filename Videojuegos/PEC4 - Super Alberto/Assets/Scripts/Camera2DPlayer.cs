using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Camera2DPlayer : MonoBehaviour
{
    //private Vector3 velocity = Vector3.zero;
    //public Text textoVidas;

    public Transform target;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (target)
        {
            Vector3 punto = GetComponent<Camera>().WorldToViewportPoint(target.position);
            Vector3 delta = target.position -
                            GetComponent<Camera>().ViewportToWorldPoint(new Vector3(0.5f, 0f, punto.z));
            Vector3 destino = transform.position + delta;

            destino.y = 0;

            transform.position = destino;
        }
    }
}

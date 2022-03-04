using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ArmaG : MonoBehaviour
{
    public GameObject balaPrefab;
    public GameObject shooter;

    private Transform _puntoDeFuego;
    
    private void Awake()
    {
        _puntoDeFuego = transform.Find("PuntoDeFuego");
    }

    void Start()
    {
        Invoke("Shoot", 1f);
        Invoke("Shoot", 2f);
        Invoke("Shoot", 3f);
        //Instantiate(balaPrefab, _puntoDeFuego.position, Quaternion.identity);
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    void Disparo()
    {
        if (balaPrefab != null && _puntoDeFuego != null && shooter != null)
        {
            GameObject miBala = Instantiate(balaPrefab, _puntoDeFuego.position, Quaternion.identity) as GameObject;

            Bala balaComponent = miBala.GetComponent<Bala>();

            //Si el arma esta mirando a la derecha...
            if (shooter.transform.localScale.x < 0f)
            {
                balaComponent.direccion = Vector2.left;
            }
            else
            {
                balaComponent.direccion = Vector2.right;
            }
        }
    }
}

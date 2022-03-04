using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Recoleccionable : MonoBehaviour
{
    private bool esRecogida = false;

    public int valor = 0;
    
    void Mostrar()
    {
        //activo imagen y animacion
        this.GetComponent<SpriteRenderer>().enabled = true;
        this.GetComponent<CircleCollider2D>().enabled = true;
        esRecogida = false;
    }

    void Ocultar()
    {
        //desactivo imagen y animacion
        this.GetComponent<SpriteRenderer>().enabled = false;
        this.GetComponent<CircleCollider2D>().enabled = false;
        
    }

    void Recolectar()
    {
        esRecogida = true;
        Ocultar();
        GameManager.sharedInstance.CollectObject(valor);
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (this.tag == "Diamante1")
        {
            //Ir a Fase 2
            SceneManager.LoadScene("Land2");
            
        } 
        if (this.tag == "Diamante2")
        {
            //Ir a Fase 2
            SceneManager.LoadScene("MenuExito");
            
        } 
        if (other.tag == "Player")
        {
            Recolectar();
        }  
    }
}

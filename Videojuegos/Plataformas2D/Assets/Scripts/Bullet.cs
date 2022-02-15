using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet : MonoBehaviour
{
    // Velocidad a la que queremos que se mueva la bala
    public float velocidad = 2f;
    //direccion de la bala
    public Vector2 direccion;

    public float livingTime = 3f;
    public Color initialColor = Color.white;
    public Color finalColor;



    // Start is called before the first frame update
    void Start()
    {
        Destroy(gameObject, livingTime);
    }

    // Update is called once per frame
    void Update()
    {
        Vector2 movimiento = direccion.normalized * velocidad * Time.deltaTime;
        // la posicion actual más el movimiento que le toca en cada frame
        // transform.position = new Vector2(transform.position.x + movimiento.x, transform.position.y + movimiento.y);
        transform.Translate(movimiento);
    }
}

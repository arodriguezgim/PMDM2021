using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyPatrol : MonoBehaviour
{

    public float velocidad = 1f;
    public float minX;
    public float maxX;
    public float waitingTime = 2f;

    private GameObject _target;
    // Start is called before the first frame update
    void Start()
    {
        UpdateTarget();
        StartCoroutine("PatroltoTarget");
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void UpdateTarget()
    {
        // Si es la primera vez, crea el target a la izquierda
        if ( _target == null)
        {
            _target = new GameObject("Target");
            _target.transform.position = new Vector2(minX, transform.position.y);
            transform.localScale = new Vector3(-1, 1, 1);
            return;
        }

        // Si estamos en la izquierda, cambiamos el target a la derecha
        if ( _target.transform.position.x == minX)
        {
            _target.transform.position = new Vector2(maxX, transform.position.y);
            transform.localScale = new Vector3(1, 1, 1);
        }
        // Si estamos enla derecha haremos lo contrario
        else if (_target.transform.position.x == maxX)
        {
            _target.transform.position = new Vector2(minX, transform.position.y);
            transform.localScale = new Vector3(-1, 1, 1);
        }
    }

    private IEnumerator PatroltoTarget()
    {
        //La corrutina moverá al enemigo
        while(Vector2.Distance(transform.position, _target.transform.position) > 0.05f)
        {
            // Moveremos el enemigo
            Vector2 direction = _target.transform.position - transform.position;
            float xDirection = direction.x;
            transform.Translate(direction.normalized * velocidad * Time.deltaTime);
            // IMPORTANTE
            yield return null;
        }

        // En este punto hemos alcanzado el objetivo
        Debug.Log("Objetivo alcanzado");
        yield return new WaitForSeconds(waitingTime);

        // Una vez hemos esperado, restauraremos el comportamiento
        UpdateTarget();
        StartCoroutine("PatroltoTarget");
    }
}

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{
    //El enemigo se moverá de izquierda a derecha, marcándole un patron.
    public float velocidad = 1f;
    public float minX;
    public float maxX;
    public float tiempoDeEspera = 2f;
    private GameObject _target;
    void Start()
    {
        UpdateTarget();
        StartCoroutine("EnemyTarget");
    }

    // Update is called once per frame
    void Update()
    {
        
    }
    private void UpdateTarget()
    	{
    		// Al crear al enemigo lo situaremos mirando a la derecha
    		if (_target == null) {
    			_target = new GameObject("Target");
    			_target.transform.position = new Vector2(minX, transform.position.y);
    			transform.localScale = new Vector3(-1, 1, 1);
    			return;
    		}
    
    		// Si el enemigo mira a la izquierda, lo moverá a la derecha
    		if (_target.transform.position.x == minX) {
    			_target.transform.position = new Vector2(maxX, transform.position.y);
    			transform.localScale = new Vector3(1, 1, 1);
    		}
    
    		// Si el enemigo mira a la derecha, lo moverá a la izquierda
    		else if (_target.transform.position.x == maxX) {
    			_target.transform.position = new Vector2(minX, transform.position.y);
    			transform.localScale = new Vector3(-1, 1, 1);
    		}
    	}
    
    //Creamos una Corrutina
    
    	private IEnumerator EnemyTarget()
    	{
	        while(Vector2.Distance(transform.position, _target.transform.position) > 0.05f) {
				//Vamos a movernos al target
    			Vector2 direction = _target.transform.position - transform.position;
    			float xDirection = direction.x;
    
    			transform.Translate(direction.normalized * velocidad * Time.deltaTime);
    
    			// No sigas ejecutando codigo, y empieza desde arriba al volverse a ejecutar
    			yield return null;
    		}
    
    		// Al llegar al target nos aseguramos que hemos llegado.
    		
    		transform.position = new Vector2(_target.transform.position.x, transform.position.y);
            
    		
    		yield return new WaitForSeconds(tiempoDeEspera); 
    
    		//Reseteamos el comportamiento
    		
    		UpdateTarget();
    		StartCoroutine("EnemyTarget");
    	}
}

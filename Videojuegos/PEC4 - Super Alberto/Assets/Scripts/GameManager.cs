using System.Collections;
using System.Collections.Generic;
using UnityEngine;



public class GameManager : MonoBehaviour
{

    //Variable que referencia al propio Game Manager
    public static GameManager sharedInstance;
    

    public int collectedObjects = 0;


    private void Awake()
    {
        sharedInstance = this;
    }

    private void Update()
    {
        
    }
    
    //Método para finalizar la ejecución del videojuego
    public void ExitGame()
    {
        #if UNITY_EDITOR
             UnityEditor.EditorApplication.isPlaying = false;
        #else
             Application.Quit();
        #endif
    }




    public void CollectObject(int objectValue){
        this.collectedObjects += objectValue;
        Debug.Log("Llevamos recogidos: "+this.collectedObjects);
    }




}

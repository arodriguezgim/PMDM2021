using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
public class VistaPartida : MonoBehaviour
{
    public Text monedasLabel;
    public Text scoreLabel;
    public Text maxscoreLabel;

    // Update is called once per frame
    void Update()
    {
        int currentObjects = GameManager.sharedInstance.collectedObjects;
        this.monedasLabel.text = currentObjects.ToString();

        float distanciaRecorrida = PlayerController.sharedInstance.ObtenerDistance();
        this.scoreLabel.text = "Puntuacion\n"+distanciaRecorrida.ToString("f1");

        float maxscore = PlayerPrefs.GetFloat("maxscore", 0);
        this.maxscoreLabel.text = "Max Puntuacion\n" + maxscore.ToString("f1");
    }
    
}

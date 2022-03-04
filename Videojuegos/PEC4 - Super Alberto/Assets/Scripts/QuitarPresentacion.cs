using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class QuitarPresentacion : MonoBehaviour
{
    private void OnMouseDown()
        {
            SceneManager.LoadScene("MainMenu");
        }
}

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Pistola : MonoBehaviour
{
    //No le asignamos nada porque lo hacemos desde Unity
    public GameObject bulletPrefab;
    private Transform _firePoint;

    private void Awake()
    {
        _firePoint = transform.Find("Firepoint");
    }

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }


    void Shoot()
    {
        if ( bulletPrefab != null && _firePoint != null)
        {
            GameObject myBullet = Instantiate(bulletPrefab, _firePoint.position, Quaternion.identity) as GameObject;

            // Bullet bulletComponent = myBullet.GetComponent<Bullet>
        }
    }


}

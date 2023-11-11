/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instapaysystem;
import java.util.Random;

public class gasBill extends bill
{
    gasBill()
    {
        type = "gas";
        Random random = new Random();
        amount = random.nextFloat((1000 - 100) + 1) + 100;
    }
}

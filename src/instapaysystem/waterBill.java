/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instapaysystem;

import java.util.Random;

/**
 *
 * @author Seif
 */
public class waterBill extends bill
{
    waterBill()
    {
        type = "water";
        Random random = new Random();
        amount = random.nextFloat((200 - 50) + 1) + 50;
    }
}

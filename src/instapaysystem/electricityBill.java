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
public class electricityBill extends bill {
    electricityBill()
    {
        type = "electricity";
        Random random = new Random();
        amount = random.nextFloat((2000 - 500) + 1) + 500;
    }
}

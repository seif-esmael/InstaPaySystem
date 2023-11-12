package instapaysystem;

import java.util.Random;

public class electricityBill extends bill
{
    electricityBill()
    {
        type = "electricity";
        Random random = new Random();
        amount = random.nextFloat((2000 - 500) + 1) + 500;
    }
}

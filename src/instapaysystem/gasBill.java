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

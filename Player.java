import java.util.*;

class Player
{
    private String playerToken = "";
    private int money = 0;
    private ArrayList<Integer> propertys = new ArrayList<Integer>();
    private int position = 0;
    private boolean inJail = false;
    private short numDoubles = 0;

    /**
     * deposit money into the account
     * @param moneyIn
     */
    public void deposit(int moneyIn) 
    {
        money += moneyIn;
    }

    /**
     * Withdraws money, if false it failed
     * @param moneyOut
     * @return result
     */
    public boolean withdraw(int moneyOut)
    {
        boolean result;
        if(moneyOut > money)
        {
            result = false;
        }
        else
        {
            result = true;
            money -= moneyOut;
        }

        return result;
    }

    /**
     * Returns money
     * @return
     */
    public int getBalance()
    {
        return money;
    }

    /**
     * Moves directly to that tile
     * @param moved
     */
    public void changePositionDirect(int newTile)
    {
        position = newTile;
    }

    /**
     * Moves up
     * @param moveUp
     */
    public void moveUp(int moveUp)
    {
        // Checks if it passed go, and adds funds accordingly
        if((position + moveUp) > 40)
        {
            money += 200;
            position = (position + moveUp) - 40;
        }
        else
        {
            position += moveUp;
        }
    }

    public void addProperty(int indexOfProperty)
    {
        propertys.add(indexOfProperty);
    }

    public boolean removeProperty(int indexOfProperty)
    {
		// Search through the array in a linear fashion, and remove the value
		boolean found = false;
		int i = 0;
        while(found == false)
		{

			// When found, stop searching
			if(propertys.get(i) == indexOfProperty)
			{
				found = true;
			}
			else
			{
				i++;
			}

			// If not found, exit and give up
			if(i == propertys.size())
			{
				found = true;
				i = -1;
			}
		}

		if(i == -1)
		{
			found = false;
		}
		else
		{
			propertys.remove(i);
		}


		return found;
    }
}
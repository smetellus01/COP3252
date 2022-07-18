public class IntegerSet 
{
	private boolean [] SetInt;
	
	public IntegerSet()
	{
		SetInt = new boolean [101];
		for(int i = 0; i <= 100; i++)
		{
			SetInt[i] = false;
		}
	};

    public IntegerSet insertElement(int data)
	{
		this.SetInt[data] = true;
		return this;
	};
	
	public IntegerSet deleteElement(int data)
	{
		this.SetInt[data] = false;
		return this;
	};

    public IntegerSet union(IntegerSet iSet)
    {
        IntegerSet TempSet = new IntegerSet();
        
        for(int i = 0; i <= 100; i++)
        {
            if(this.SetInt[i] == true || this.SetInt[i] == true)
            {
                TempSet.SetInt[i] = true;
            }
        }

        return TempSet; 
    };

    public IntegerSet intersection(IntegerSet iSet)
	{
        IntegerSet TempSet = new IntegerSet();

        for(int i = 0; i <= 100; i++)
        {
            if(this.SetInt[i] == true && iSet.SetInt[i] == true)
            {
                    TempSet.SetInt[i] = true;
            }
        }

        return TempSet;
    };
    
    public boolean isEqualTo(IntegerSet iSet)
	{
        boolean result = true;

        for(int i = 0; i <= 100; i++)
        {
            if(this.SetInt[i] != iSet.SetInt[i])
            {
                result = false;
            }
        }

        return result;
    };

    public String toString()
	{
        boolean Empty = true;
        String test = new String();

        for(int i = 0; i <= 100; i++)
        {
            if(this.SetInt[i] == true)
            {
                test = new String(test + " " + i);
                Empty = false;
            }
        }

        if(Empty = true)
        {
            test = new String("---");
        }

        return test;
    };

}

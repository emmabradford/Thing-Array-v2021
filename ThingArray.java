
/**
 * Write a description of class ThingArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class ThingArray
{
    private String name;
    private Thing[] list;
    private int size;
    
    public ThingArray(String n)
    {
        name = n;
        list = new Thing[4];
        size = 0;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getSize()
    {
        //return 0;
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public boolean isFull()
    {
        return size == list.length;
    }
    
    public void add(Thing a)
    {
        checkSize();
        list[size] = a;
        size++;
    }
    
    public Thing get(int i)
    {
        return list[i];
        //return list[0];
    }
    
    public int indexOf(Thing a)
    {
        for(int x = 0; x < size; x++)
        {
            if(list[x].equals(a))
            {
                return x;
            }
        }
        return -1;
    }
    
    public boolean contains(Thing a)
    {
        return this.indexOf(a) != -1;
    }
    
    public String toString()
    {
        String ans = "";
        for(int x = 0; x < list.length; x++)
        {
            ans +=  x + ": " + list[x].getAmount() + "\n";
        } 
        return ans;
    }
    
    public Thing set(int i, Thing a)
    {
        Thing ans = list[i];
        list[i] = a;
        return ans;
    }
    
    private void checkSize()
    {
        int newSize = 0;
        if(isFull())
        {
            newSize = list.length * 2;
        }
        else if(size < list.length / 4)
        {
            newSize = list.length / 2;
        }
        else
        {
            //newSize = size;
            return;
        }
        
        Thing[] temp = new Thing[newSize];
        for(int a = 0; a < size; a++)
        {
            temp[a] = list[a];
        }
        list = temp;
    }
    
    public void add(int i, Thing a)
    {
        checkSize();
        for(int x = size; x > i; x--)
        {
            Thing temp = list[x-1];
            list[x] = temp;
        }
        
        //checkSize();
        list[i] = a;
        size++;
    }
    
    public Thing remove(int index)
    {
        checkSize();
        Thing temp = list[index];
        for(int i = index; i < size; i++)
        {
            list[i] = list[i+1];
        }
        list[size] = null;
        size--;
        return temp;
    }
    
    public boolean remove(Thing a)
    {
        Thing temp;
        if(indexOf(a) != -1)    
        {
            temp = remove(indexOf(a));
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void clear()
    {
        while(!isEmpty())
        {
            remove(0);
        }
    }
    
    public void sort()
    {
        int i = 0;
        boolean swapped = true;
        while((i < size - 1) && swapped)
        {
            swapped = false;
            i++;
            for(int j = 0; j < size - i; j++)
            {
                if(list[j].compareTo(list[j + 1]) > 0)
                {
                    Thing temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
}       

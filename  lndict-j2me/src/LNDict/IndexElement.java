/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LNDict;

/**
 *
 * @author Le Van Long
 */
public class IndexElement {
    public static final char SEPERATOR = '|';
    private String m_Word;
    private int m_Position;
    private int m_Length;

    public IndexElement()
    {
        m_Word = "";
        m_Position = -1;
        m_Length = -1;
    }

    public void setWord(String word)
    {
        m_Word = word;
    }

    public String getWord()
    {
        return m_Word;
    }

    public void setPosition(int position)
    {
        m_Position = position;
    }

    public int getPosition()
    {
        return m_Position;
    }

    public void setLength(int length)
    {
        m_Length = length;
    }

    public int getLength()
    {
        return m_Length;
    }

    public String toString()
    {
        String result = "";
        result += m_Word;
        result += (SEPERATOR + m_Position);
        result += (SEPERATOR + m_Length + "\r\n");
        return result;
    }

    // Reference: http://ruchiram4.blogspot.com/2009/05/j2me-split-string-code-segment.html
    public static String[] split(String str, String delimiter)
    {
        int delimiterCount=0;
        int index = -1;        

        while((index=str.indexOf(delimiter, index + 1))!= -1)
        {
            //tmpStr=tmpStr.substring(index+delimiter.length());
            delimiterCount++;
        }

        // Trong bài này không xử lý trường hợp các ký tự phân
        // tách nằm ở đầu và cuối chuỗi


        String[] splittedList;
        splittedList=new String[delimiterCount + 1];

        //-----------------------------------------------//
        index=0;
        int counter=0;
        String tmpStr=str;
        int nextIndex = -1;
        while((nextIndex = tmpStr.indexOf(delimiter))!= -1)
        {
            splittedList[counter] = tmpStr.substring(index, nextIndex);
            counter++;
            tmpStr = tmpStr.substring(nextIndex + 1);
        }

        if (tmpStr.length() > 0)
        {
            if (tmpStr.substring(tmpStr.length() - 2).compareTo("\r\n") == 0)
            {
                tmpStr = tmpStr.substring(0, tmpStr.length() - 2);
            }
            splittedList[counter] = tmpStr;
        }

        return splittedList;
    }

    public void parse(String input)
    {
        String[] arrElement = IndexElement.split(input, "|");
        if (arrElement.length == 3)
        {
            m_Word = arrElement[0];
            m_Position = Integer.parseInt(arrElement[1]);
            m_Length = Integer.parseInt(arrElement[2]);
        }
    }    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LNDict;

import java.util.Vector;
import java.io.*;
/**
 *
 * @author Le Van Long
 */
public class Processor
{
    public static Vector readFromFile(InputStream stream) throws IOException
    {
        //IndexElement[] result = new IndexElement[27];
        Vector result = new Vector();

        StringBuffer buf = new StringBuffer();
        int c;
        //int index = 0;
        try
        {
            while ((c = stream.read()) != -1)
            {
               buf.append((char)c);
               if (c == '\n')
               {
                   IndexElement element = new IndexElement();
                   element.parse(buf.toString());
                   result.addElement(element);
                   //index++;

                   buf.delete(0, buf.length());
               }
            }
        }
        catch(IOException e)
        {
            throw e;
        }

        return result;
    }

    public static int binarySearch(String key, Vector searchArea)
    {        
        int left = 0;
        int right = searchArea.size();
        int mid = -1;
        int compare;
        while (left <= right)
        {
            mid = (left + right)/2;
            compare = key.compareTo(((IndexElement)searchArea.elementAt(mid)).getWord());
            if (compare < 0)
            {
                right = mid - 1;
            }
            else if (compare > 0)
            {
                left = mid + 1;
            }
            else
            {
                return mid;
            }
        }

        return -1;
    }

    public static String readMeaningString(InputStream stream, int position, int length) throws IOException
    {
        //StringBuffer buf = new StringBuffer();
        byte[] byteBuf = new byte[length];
        
        try
        {
            stream.skip(position);
//            int c;
//            int count = 0;
//            while ((c = stream.read()) != -1 && count < length)
//            {
//                buf.append((char)c);
//                count++;
//            }
            stream.read(byteBuf, 0, length);
        }
        catch(IOException ex)
        {
            throw ex;
        }

        String result = UTF8Decode(byteBuf, 0, length);
        return result;
    }

// region: reference
/*

Author : Shivakumar
Mail   : shiva (at) blisspark.com
Disclaimer : This code is provided without any implied or expressed warranty and may not work as
expected. If have any bugs, inform me or post the fix here.

*/

    public static String UTF8Decode(byte in[], int offset, int length)
    {
	StringBuffer buff = new StringBuffer();
	int max = offset + length;
	for( int i = offset ; i < max ; i++)
	{
		char c = 0;
		if((in[i] & 0x80) == 0)
		{
			c = (char) in[i];
		}
		else if(( in[i] & 0xe0 ) == 0xc0)	// 11100000
		{
			c |= ((in[i] & 0x1f) << 6);		// 00011111
			i++;
			c |= ((in[i] & 0x3f) << 0);		// 00111111
		}
		else if(( in[i] & 0xf0) == 0xe0)	// 11110000
		{
			c |= ((in[i] & 0x0f) << 12);	// 00001111
			i++;
			c |= ((in[i] & 0x3f) << 6);		// 00111111
			i++;
			c |= ((in[i] & 0x3f) << 0);		// 00111111
		}
		else if((in[i] & 0xf8) == 0xf0)		// 11111000
		{
			c |= ((in[i] & 0x07) << 18);	// 00000111 (move 18, not 16?)
			i++;
			c |= ((in[i] & 0x3f) << 12);	// 00111111
			i++;
			c |= ((in[i] & 0x3f) << 6);		// 00111111
			i++;
			c |= ((in[i] & 0x3f) << 0);		// 00111111
		}
		else
		{
			c = '?';
		}
		buff.append(c);
	}
	return buff.toString();
    }
}

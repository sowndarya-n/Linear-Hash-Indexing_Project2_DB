
/*******************************************************************************
 * @file  FileList.java
 *
 * @author   John Miller
 */

import java.io.*;
import static java.lang.System.out;
import java.util.*;

/*******************************************************************************
 * This class allows data tuples/tuples (e.g., those making up a relational table)
 * to be stored in a random access file.  This implementation requires that each
 * tuple be packed into a fixed length byte array.
 */
public class FileList
       extends AbstractList <Comparable []>
       implements List <Comparable []>, RandomAccess
{
    /** File extension for data files.
     */
    private static final String EXT = ".dat";

    /** The random access file that holds the tuples.
     */
    private RandomAccessFile file;

    /** The name of table.
     */
    private final String tableName;

    /** The number bytes required to store a "packed tuple"/record.
     */
    private final int recordSize;

    /** Counter for the number of tuples in this list.
     */
    private int nRecords = 0;

    /***************************************************************************
     * Construct a FileList.
     * @param _tableName   the name of the table
     * @param _recordSize  the size of tuple in bytes.
     */
    public FileList (String _tableName, int _recordSize)
    {
        tableName  = _tableName;
        recordSize = _recordSize;

        try {
            file = new RandomAccessFile (tableName + EXT, "rw");
        } catch (FileNotFoundException ex) {
            file = null;
            out.println ("FileList.constructor: unable to open - " + ex);
        } // try
    } // constructor

    /***************************************************************************
     * Add a new tuple into the file list by packing it into a record and writing
     * this record to the random access file.  Write the record either at the
     * end-of-file or into a empty slot.
     * @param tuple  the tuple to add
     * @return  whether the addition succeeded
     */
    public boolean add(Comparable[] tuple) 
    {
           //-----------------\\
          // TO BE IMPLEMENTED \\
         //---------------------\\
        try {
            // Calculating the total size needed for the packed tuple, including spaces and a newline character
            int totalSize = 0;
            for (Comparable value : tuple) 
            {
                String stringValue = value.toString();
                // Converting to bytes
                byte[] valueBytes = stringValue.getBytes("UTF-8"); 
                totalSize += valueBytes.length;
                totalSize += 1; // Account for the space character
            }
            totalSize += 1; // Account for the newline character
    
            // Creating a byte array to hold the packed tuple
            byte[] record = new byte[totalSize];
    
            // Packing the tuple into the record
            int offset = 0;
            for (Comparable value : tuple) {
                String stringValue = value.toString();
                // Converting into bytes
                byte[] valueBytes = stringValue.getBytes("UTF-8"); 
                int valueLength = valueBytes.length;
                System.arraycopy(valueBytes, 0, record, offset, valueLength);
                offset += valueLength;
                // Adding a space character after each field
                record[offset] = ' ';
                 // Moving the offset to next position
                offset += 1;
            }
    
            // Appending a newline character to the record to separate each tuple
            record[offset] = '\n';
    
            // Seeking to the end of the file and write the record to the file
            file.seek(file.length());
            file.write(record);
    
            // Incrementing the counter that holds the number of records
            nRecords++;
            return true;
        } 
        catch (IOException ex) 
        {
            out.println("FileList.add: unable to write to the file - " + ex);
            return false;
        }
    }//add


    /***************************************************************************
     * Get the ith tuple by seeking to the correct file position and reading the
     * record.
     * @param i  the index of the tuple to get
     * @return  the ith tuple
     */    
    public Comparable[] get(int i) {
           //-----------------\\
          // TO BE IMPLEMENTED \\
         //---------------------\\
        try {
            // Checking if the requested index of the tuple is out of bounds
            if (i < 0 || i >= nRecords) 
            {
                //If it is out of bound print a Not found message
                System.out.println("No tuple at the " + i +"th position");
                return null;
            }
    
            // Seek to the beginning of the file.
            file.seek(0);
    
            // Reading the records until the ith record is reached.
            for (int j = 0; j < i; j++) 
            {

                String line = file.readLine();
                if (line == null) {
                    // Handling the case when there is no ith record stored
                    System.out.println("No tuple at the " + i +"th position");
                    return null;
                }
            }
    
            // Reading the ith record from the file.
            String recordString = file.readLine();
    
            if (recordString != null) 
            {
                // Splitting the recordString into fields using the regex pattern.
                String[] tupleFields = recordString.split(" "); 
    
                // Creating a tuple with the extracted fields
                Comparable[] tuple = tupleFields;
    
                //Debug statement that prints the ith tuple 
                System.out.println("Tuple at the " + i+"th position is : " + Arrays.toString(tuple));
                return tuple;
            }
        } 
        catch (IOException e) 
        {
            out.println("FileList.get: seek or read failed - " + e);
        }
        return null;
    }//get
    
    /***************************************************************************
     * Return the size of the file list in terms of the number of tuples/records.
     * @return  the number of tuples
     */
    public int size ()
    {
        return nRecords;
    } // size

    /***************************************************************************
     * Close the file.
     */
    public void close ()
    {
        try {
            file.close ();
        } catch (IOException ex) {
            out.println ("FileList.close: unable to close - " + ex);
        } // try
    } // close

} // FileList class


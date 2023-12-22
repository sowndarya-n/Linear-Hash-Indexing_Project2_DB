# Project- 2 - Database Management (CSCI 6370)

# Project Overview:
In the context of this project, we aim to implement the Indexing using the Linear Hashing technique.

# Linear Hashing:
It is a flexible and disk-based indexing technique that utilizes hashing to manage data efficiently. It can adapt to changing data sizes by adjusting the number of buckets it uses, and its strength lies in its ability to quickly find records with specific keys, making it a valuable tool for database management and information retrieval systems.

In the scope of our project, to use the Linear Hash we have implemented code for split and set functions.

(i) Split:
The split function we defined first creates a new bucket chain at the end of the hash table. We then go through all the keys in the 'isplit' bucket chain, and for each key, we calculates a high-resolution hash value using 'h2' defined in the project scope. If that hash value doesn't match the current 'isplit', the key is moved to the new bucket chain. After handling all the keys, we increment the 'isplit' counter. If 'isplit' reaches a certain threshold (mod1), we reset it to zero, and the hash functions mod1 and mod2 are updated.

(ii) Set:
Using the set function, we make an empty set to gather key-value pairs. Afterward, we go through the hash table. For each bucket in it, we look at the key-value pairs it holds. While doing this, we create entry objects that stand for keys and values. These entries go into the set. When we've checked all the buckets, the function gives back the set with all the map's key-value pairs.

# Select Method:
The 'select' method finds specific rows in a table based on a provided 'keyVal' parameter. It does this by using an 'index' data structure to locate and collect the rows associated with the given 'keyVal.' Once it has gathered these rows, it creates a new table that retains the same attributes, domains, and keys as the original table. Additionally, it increments a count identifier used to distinguish the new table from others. This method essentially enables the extraction of relevant data from the table based on a specified key value.

# Indexed Join Method:
In the 'i_join' method, we are combining two tables, the current one 'table1' and 'table2', using indexed join technique. We can choose which columns in each table to compare for matching values.

Firstly, we create a special index for 'table2' to speed up the matching process. Then, we iterate through the rows in our current table, looking up corresponding rows in 'table2' using this index. Whenever we find matching pairs, we put them together and create a new table that holds all the combined data, including attributes and types from both tables. To ensure each newly created table is uniquely identifiable, we emply a counter and increment it accordingly.

# Bonus:
We have implememted the storage for i_join and indexed_select tables using FileList that is built using Java's RandomAccessFile.
In this we have used two methods: add and get.

(i) add:
In the add method, the FileList class is responsible for inserting data tuples into a specified file. We first calculated the space needed for each tuple dynamically, considering the content's length. After packing the data, we appended a newline character to separate records and stored them in the .dat file. We provided error handling to report and manage any exceptions that might occur duiring the file creation and ensured the reliable addition of data into the file.

(ii) get:
In thee get method, we retrieves a data tuple from a specific index within a file. We handled the out-of-bounds checks and printed a debug statement whenever the requested index doesn't exist. Also, the method seeks to the beginning of the file, iterates through records, and looks for the ith tuple specified. We then converted and returned the tuple as an array of comparable values. We used the debug statement to log the output of the get method.

# Instructions for code execution:

1. Download or clone the repository.
2. Ensure that your local system has the Java Development Kit (JDK) installed and the Java path is correctly configured in the Environmental Variables.
3. Verify that the folder structure includes the "store" folder for saving database files.
4. To compile the code, execute the following command in the terminal:
   javac MovieDB.java
5. If compilation encounters an error, an error message will be displayed in the command prompt.
6. Upon successful compilation, run the code using the following command:
   java MovieDB
7. Successful execution will create database files within the "store" folder. In case of any issues, an IOException will be raised..
8. In the command line, the result will be displayed, showcasing the implementation of the indexed select and join operations.

# Team Members:
V H Sowndarya Nookala (Manager)
Rohith Lingala
Krishna Chaitanya Velagapudi
Bavesh Chowdary Kamma 
Subhasree Nadimpalli

# Conclusion:
We completed the project within the deadline by following the effective task segregation, testing and evaluation of the operators by ensuring that they perform their intended functions accurately. 
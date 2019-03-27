package profoundmasteryinidiocy.gmail.com.schedulermaybe.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.Model.Question;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DB_NAME = "questionsDatabase";
    private static final String TABLE_NAME = "questionsTable";

    private static final String KEY_ID = "id";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_CHOICE_ONE = "choice_one";
    private static final String KEY_CHOICE_TWO = "choice_two";
    private static final String KEY_CHOICE_THREE = "choice_three";
    private static final String KEY_CHOICE_CORRECT = "choice_correct";
    private static final String KEY_TOPIC = "topic";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_SUBCATEGORY = "subcategory";
    private Context ctx;
    private List<String> initialize_questions = new ArrayList<>();

    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        this.ctx = context;
    }
    
    public void addQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, question.getQuestion());
        values.put(KEY_CATEGORY, question.getCategory());
        values.put(KEY_SUBCATEGORY, question.getSubcategory());
        values.put(KEY_CHOICE_ONE, question.getChoice());
        values.put(KEY_CHOICE_TWO, question.getChoice2());
        values.put(KEY_CHOICE_THREE, question.getChoice3());
        values.put(KEY_CHOICE_CORRECT, question.getAnswer());
        values.put(KEY_TOPIC, question.getTopic());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //Systematically generated in functionsFromTxt.py
    public void initializeQuestions(){
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('In what year did the idea for FBLA originate?', '1953', '1969', '1911', '1937', 'fbla_essentials', 'Dates', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('In which year did FBLA’s annual membership top 200,000?', '2001', '1999', '2012', '1987', 'fbla_essentials', 'Dates', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When was the FBLA-Middle Level division formed?', '1963', '1925', '1972', '1994', 'fbla_essentials', 'Dates', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When was the PBL division of FBLA formed?', '1942', '1994', '1971', '1958', 'fbla_essentials', 'Dates', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When was FBLA’s national center opened?', '1974', '1952', '2005', '1991', 'fbla_essentials', 'Dates', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When was FBLA granted independent status as a nonprofit educational student association?', '1983', '1992', '1954', '1969','fbla_essentials', 'Dates', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('In what year was the alumni division approved?', '1969', '1956', '1978', '1979', 'fbla_essentials', 'Dates', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Who is the founder of FBLA?', 'Edward D. Miller', 'Jean Buckley', 'Eu Ro Wang', 'Hamden L. Forker', 'fbla_essentials', 'People', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Who was appointed president and chief executive officer of FBLA in 1997', 'Edward D. Miller', 'Hamden L. Forker', 'Eu Ro Wang', 'Jean Buckley', 'fbla_essentials', 'People', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Who was appointed FBLA’s full-time executive director in 1973?', 'Hamden L. Forkner', 'Jean M. Buckley', 'Ashlee Woodson','Edward D. Miller', 'fbla_essentials', 'People', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which state had the first FBLA state chapter?', 'Arizona', 'Washington D.C.', 'Maryland', 'Iowa', 'fbla_essentials', 'Locations', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Where was the first Headquarters office for FBLA', 'New York', 'Iowa', 'North Carolina', 'Washington, D.C.', 'fbla_essentials', 'Locations', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Where is FBLA’s national center?', 'Maryland', 'Texas', 'Washington, D.C.', 'Virginia', 'fbla_essentials', 'Locations', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which organization was the first to sponsor FBLA', 'Conrad N. Foundation', 'National Business Education Association', 'Accreditation Council for Business Schools and Programs', 'National Council for Business Education', 'fbla_essentials', 'Locations', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which university chartered the first collegiate chapter of FBLA', 'University of Arizona', 'University of Washington', 'University of Texas at Austin', 'University of Northern Iowa', 'fbla_essentials', 'Locations', 'FBLA History');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is a snapshot of a system state that is used for a system restore?', 'Microsofts current file system, faster, supports larger drives, and supports encryption, but is incompatible with other operating systems', '  Restart the program', '  Small Computer System Interface, the major standard of serial ports', '  Restore point', 'competitive_events', 'Security', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('15. What is the most important activity that users must do when handling sensitive data?', '  Attract the toner from the drum to the paper.', '  Did you scan the file for viruses before opening it?', '  User ID with a reusable password', '  Log off of their workstations when they leave', 'competitive_events', 'Security', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('16. What is the most common form of identification and authentication?', '  Problem with motherboard', '  Log off of their workstations when they leave', '  Product Activation', '  User ID with a reusable password', 'competitive_events', 'Security', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is CMOS?', 'Unshielded twisted pair, the most common type of networking cable, includes most phone and Ethernet lines', 'A section of a hard drive dedicated to software to be loaded when the the computer isturned on, like BIOS', 'Shielded twisted pair, cable is protected with metallic substance toreduce interference, rare due to expense', 'A battery-powered memory chip in your computer that stores start-up information. BIOS uses this information when starting your computer.', 'competitive_events', 'PC Components', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How many bits make up a byte?', '  1000000000000', '  802.11', '  127', '  8', 'competitive_events', 'PC Components', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('17. What is the term for simulating memory using hard drive space?', '  HKEY_LOCAL_MACHINE/SYSTEM', '  Microprocessor', '  Direct download, disk', '  Virtual memory', 'competitive_events', 'PC Components', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is a major security feature introduced in XP?', '  The program file is corrupt or deleted', '  Displays list of programs associated with file types', '  Install a bidirectional cable', '  Digital Certificates, verify identity of creators', 'competitive_events', 'Operating Systems', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('5. Which version of Windows integrated consumer and business features into one OS with different versions?', '  Allow-Read and Execute', '  RAM', '  Allow- Modify', '  XP', 'competitive_events', 'Operating Systems', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('8. What does Windows command assoc do?', '  First line of processors to be totally 64-bit', '  Problem with keyboard','  Speed up HHD access by using a part of RAM to cache data', '  Displays list of programs associated with file types', 'competitive_events', 'Operating Systems', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('10. What key would you press in Emergency Repair Disk to restore the registry?', '  Virtual memory', '  Allow- Write','  DDR2 SDRAM', '  F (fast repair)', 'competitive_events', 'Operating Systems', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which standard defines wireless networking?', '802.11b (Wi-Fi)', '35-40 degrees C (95-104 F)', '5 meters', '802.11', 'competitive_events', 'Networking', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('9. What is a network topology?', '  When devices are connected to each other in varying ways', '  Microsoft MS-DOS CD-ROM Extensions', '  The second cache the CPU uses, sometimes as an expansion', '  The structure of a computer network', 'competitive_events', 'Networking', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('1What does ISDN stand for?', '  Problem with printer', '  Integrated Services Digital Network', '  Uniformly charges the drum to reset it between printouts.', '  Displays a text file', 'competitive_events', 'Networking', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('19. What does FDDI stand for?', '  The structure of a computer network', '  Microsoft MS-DOS CD-ROM Extensions', '  Problem with video adapter', '  Fiber Distributed Data Interface', 'competitive_events', 'Networking', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('7. What is the most likely consequence of a sudden power outage?', '  Lost data', '  Identity theft', '  Authentication', '  Virtual memory', 'competitive_events', 'Safety', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('1When sitting a workstation, what angle should a users forearm be to their body?', '  1-11', '  XGA', '  RAM', '  90', 'competitive_events', 'Safety', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('18 What is STP?', 'Wi-Fi Protected Setup, a one-touch Wi-Fi security protocol', 'Wi-Fi Protected Access, a newer security algorithm for Wi-Fi.', 'Master Boot Record, a special type of boot sector data that sortsand verifies drive partitions', 'Shielded twisted pair, cable is protected with metallic substance to reduce interference, rare due to expense .', 'competitive_events', 'Safety', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the super high 4:3 monitor resolution, defined by 1600x1200?', '  CHKDSK', '  Yes.', '  User ID with a reusable password', '  UXGA', 'competitive_events', 'Devices', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is control set data?', '  Data of system configuration information such as device drivers and services.', '  An older file system, can be read and written to by almost any operating system', '  When devicesare connected to two other devices on either side, creating a circle', '  Heats up and meltsthe toner unto the surface of the paper.', 'competitive_events', 'Devices', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('12 What is the best way to fix the problem of having a bidirectional printer and driver but unidirectional cable? ', 'HKEY_LOCAL_MACHINE/SYSTEM', 'Identity theft', 'Log off of their workstations when they leave', 'Install a bidirectional cable', 'competitive_events', 'Printers/Scanners', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('15.   A 201 error at system startup means what?', 'bad hard disk system', 'bad floppy drive', 'bad system board', 'bad memory', 'competitive_events', 'Hardware', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('The first thing you can do to increase the available conventional memory is', ' rearrange the loading order of the drivers.', ' remove DOS.', 'load all device drivers into UMBS.', 'add DOS-HIGH to the CONFIG.SYS.', 'competitive_events', 'Hardware', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('  Before you install a new device in a functioning computer, you should', 'disassemble the computer.', 'install DOS.',' install MSD.', 'determine the computers available resources.', 'competitive_events', 'Hardware', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('10.   Which of the following is true of master/slave hard drive configurations?', 'Do not mix ATA and IDE drives on a single controller.', 'The primary controller must contain drives that are technologically similar to or newer than drives on the secondary controller.', 'Do not install drives on the secondary controller without a primary slave present.', 'Do not configure a hard drive to be CD-ROM drives slave.', 'competitive_events', 'Hardware', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('1  A customer is complaining that the power in the office sometimes surges, sometimes causes blackouts, and has EMI. What single device can you recommend to help the most in this situation?', 'a suppressor', 'a backup battery', 'a noise filter', ' a UPS', 'competitive_events', 'Hardware', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('6.   What tool is used tocheck a machine for hard drive errors?', 'System Monitor', 'Disk Cleanup', 'Disk Fragmenter', 'SCANDISK', 'competitive_events', 'Programs', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('1  A macro is a:', 'a series of commands that allow the user to display a larger version of a document', 'document that contains the formatting necessary for a specific document type', 'collection of drawings, diagrams, and photographs that can be inserted into a document', 'sequence of keystrokes and instructions that a user records and saves', 'competitive_events', 'Programs', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES(' Which type of signal degrades the most over longer distances?', 'analog', 'serial', 'parallel', 'Digital', 'competitive_events', 'Programs', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('  What devices transfer packets across multiple networks and use tables to store network addresses to determine the best destination?', 'brouters', 'gateways', 'bridges', 'routers', 'competitive_events', 'Programs', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('8.   Transmission ControlProtocol/lnternet Protocol (TCP/IP) is a collection of protocols that help manage Internet communication. Each computer running TCP/IP must have a unique IP address assigned to it. Which of the following statements best describes an IP address?', 'IP addresses are composed of four numbers, each of which is between 1 and 256. These numbers can be automatically provided or assigned by a system administrator.', ' An IP address is a set of three numbers, each of which must be from 0 to 255. An IP address is a unique name that identifies the computer within a network. This name can be automatically provided or assigned by a system administrator.','An IP address is no more than your dial-up telephone number.', 'An IP address is a set of four numbers, each of which must be from 0 to 255. These numbers can be automatically providedor assigned by a system administrator.', 'competitive_events', 'Programs', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What was the first 32-bitpreemptive multitasking system?', 'Windows 3', 'Windows 2', 'Windows 1', 'Windows 95', 'competitive_events', 'Operating Systems', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following isnot a part of the graphical phase of Windows 2000 Setup?', 'networking setting/installing components', 'fate and time settings', 'regional setting', 'partitioning the hard drive', 'competitive_events', 'Operating Systems', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which Windows error is caused by an application being greedy and taking memory away from other programs?', 'System Fault', 'Memory Protection Fault', 'General System Error', 'General Protection Fault', 'competitive_events', 'Operating Systems', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the disadvantage of FAT32?', 'You do not have to create multiple partitions.', 'It is compatible with all versions of DOS and other operating systems.', 'It supports drives up to 2 terabytes.', 'Its not compatible with older versions of DOS or with Windows 3.x and Windows 95 operating systems.','competitive_events', 'Software', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('In order to delete and/orreplace system files, which command must you use to remove the hidden, system, ad read-only attributes on the file before you replace the file?', 'DELETE', 'ATTRIB', 'UNDELETE', 'ERASE', 'competitive_events', 'Functions', 'Intro to IT');");    }
    //----------------------------------------------

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_questions_table = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_QUESTION + " TEXT,"
                + KEY_CHOICE_ONE + " TEXT,"
                + KEY_CHOICE_TWO + " TEXT,"
                + KEY_CHOICE_THREE + " TEXT,"
                + KEY_CHOICE_CORRECT + " TEXT,"
                + KEY_CATEGORY + " TEXT,"
                + KEY_SUBCATEGORY + " TEXT,"
                + KEY_TOPIC + " TEXT);";

        db.execSQL(create_questions_table);
        initializeQuestions();
        for(String x : initialize_questions){
            db.execSQL(x);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public List<Question> getAllQuestions() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                KEY_ID,KEY_QUESTION, KEY_CHOICE_ONE, KEY_CHOICE_TWO,
                KEY_CHOICE_THREE, KEY_CHOICE_CORRECT,
                KEY_TOPIC, KEY_CATEGORY, KEY_SUBCATEGORY}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(Integer.parseInt(cursor.getString(0)));
                question.setQuestion(cursor.getString(1));
                question.setChoice(cursor.getString(2));
                question.setChoice2(cursor.getString(3));
                question.setChoice3(cursor.getString(4));
                question.setAnswer(cursor.getString(5));
                question.setTopic(cursor.getString(6));
                question.setCategory(cursor.getString(7));
                question.setSubcategory(cursor.getString(8));

                questionList.add(question);
            }
            while (cursor.moveToNext());
        }
        return questionList;
    }
    public List<Question> getQuestionsByTopic(String topic) {

        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                KEY_ID,KEY_QUESTION, KEY_CHOICE_ONE, KEY_CHOICE_TWO,
                KEY_CHOICE_THREE, KEY_CHOICE_CORRECT,
                KEY_TOPIC, KEY_CATEGORY, KEY_SUBCATEGORY}, KEY_TOPIC + "=?", new String[]{topic}, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(Integer.parseInt(cursor.getString(0)));
                question.setQuestion(cursor.getString(1));
                question.setChoice(cursor.getString(2));
                question.setChoice2(cursor.getString(3));
                question.setChoice3(cursor.getString(4));
                question.setAnswer(cursor.getString(5));
                question.setTopic(cursor.getString(6));

                question.setCategory(cursor.getString(7));
                question.setSubcategory(cursor.getString(8));

                questionList.add(question);
            }
            while (cursor.moveToNext());
        }
        return questionList;
    }
    public List<String> getTopicListByCategory(String category){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                KEY_TOPIC}, KEY_CATEGORY + "=?", new String[]{category},
                null, null, KEY_TOPIC + " ASC", null);
        List<String> topicList = new ArrayList<>();

        if(cursor.moveToFirst()){
            while(cursor.moveToNext()) {
                if(!topicList.contains(cursor.getString(0))){
                    topicList.add(cursor.getString(0));
                }

            }
        }
        return topicList;
    }
    public List<String> getTopicList(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                        KEY_TOPIC}, null,
                null, null, null, KEY_TOPIC + " ASC", null);
        List<String> topicList = new ArrayList<>();

        if(cursor.moveToFirst()){
            while(cursor.moveToNext()) {
                if(!topicList.contains(cursor.getString(0))){
                    topicList.add(cursor.getString(0));
                }

            }
        }
        return topicList;
    }
    public List<String> getSubcategoryByTopic(String topic){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                        KEY_SUBCATEGORY}, KEY_CATEGORY + "=?", new String[]{topic},
                null, null, KEY_SUBCATEGORY + " ASC", null);
        List<String> subCateList = new ArrayList<>();

        if(cursor.moveToFirst()){
            while(cursor.moveToNext()) {
                subCateList.add(cursor.getString(0));
            }
        }
        return subCateList;
    }

        public void deleteQuestion (Question question){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_NAME, KEY_ID + "=?",
                    new String[]{String.valueOf(question.getId())});
        }
    public void clearDatabase(String TABLE_NAME) {
        SQLiteDatabase db = getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+TABLE_NAME;
        db.execSQL(clearDBQuery);
    }



    //GETTERS AND SETTERS


    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    public static String getDbName() {
        return DB_NAME;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getKeyId() {
        return KEY_ID;
    }

    public static String getKeyQuestion() {
        return KEY_QUESTION;
    }

    public static String getKeyChoiceOne() {
        return KEY_CHOICE_ONE;
    }

    public static String getKeyChoiceTwo() {
        return KEY_CHOICE_TWO;
    }

    public static String getKeyChoiceThree() {
        return KEY_CHOICE_THREE;
    }

    public static String getKeyChoiceCorrect() {
        return KEY_CHOICE_CORRECT;
    }

    public static String getKeyTopic() {
        return KEY_TOPIC;
    }

    public static String getKeyCategory() {
        return KEY_CATEGORY;
    }

    public static String getKeySubcategory() {
        return KEY_SUBCATEGORY;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }
}


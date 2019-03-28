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


    private static final int DATABASE_VERSION = 5;
    private static final String DB_NAME = "questionsDatabase";
    //QUESTIONS DATABASE PARAMETERS
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
    //--------------------------------------------------------------------

    //Systematically generated in functionsFromTxt.py
    //Initializes questions
    public void initializeQuestions(){initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How much does the NLC Early Bird Registration cost for members and advisers?', '$130', '$150', '$100', '$120', 'fbla_essentials', 'Costs', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How much does the NLC Early Bird registration cost for guests?', '$60', '$50', '$45', '$55', 'fbla_essentials', 'Costs', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How much does the NLC Regular registration cost for members and advisers?', '$140', '$155', '$145', '$130', 'fbla_essentials', 'Costs', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How much does the NLC Regular registration cost for guests?', '$50', '$55', '$60', '$65', 'fbla_essentials', 'Costs', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How much does the NLC On-site registration cost for members and advisers?', '$170', '$155', '$165', '$180', 'fbla_essentials', 'Costs', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How much does the NLC On-site registration cost for guests?', '$95', '$110', '$85', '$105', 'fbla_essentials', 'Costs', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Where will NLC be held in 2019?', 'Austin, TX', 'Dallas, TX', 'Houston, TX', 'San Antonio, TX', 'fbla_essentials', 'Locations', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following airlines partnered with FBLA to offer discounted travels for NLC?', 'Southwest Airlines', 'American Airlines', 'Jetblue', 'United Airlines', 'fbla_essentials', 'Locations', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When must you register to receive the Early-Bird rates for NLC?', 'On or before May 18th', 'May 18th - June 10th', 'On or before June 10th', 'On or before May 16th', 'fbla_essentials', 'Dates', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When must you register to receive the Regular rates for NLC?', 'On or before May 16th', 'On or before May 18th', 'June 11th to On-site', 'May 18th - June 10th', 'fbla_essentials', 'Dates', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When must you register to receive the On-site rates for NLC?', 'May 18th - June 10th', 'On or before May 16th', 'On or before May 18th', 'June 11th to On-site', 'fbla_essentials', 'Dates', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When will NLC take place in 2019 for FBLA?', 'June 28th  - July 1st', 'June 26th  - June 30th', 'June 17th - July 20th', 'June 29th - July 2nd', 'fbla_essentials', 'Dates', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When will NLC take place in 2019 for PBL?', 'June 28th  - July 1st', 'June 26th  - June 30th', 'June 17th - July 21st', 'June 24th - June 27th', 'fbla_essentials', 'Dates', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When is the duration of the FBLA flight discount?', 'June 23rd - July 3rd', 'June 28th - July 2nd', 'June 15th - June 28th', 'June 20th - July 5th', 'fbla_essentials', 'Dates', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When must refund requests be submitted?', 'June 17th', 'June 10th', 'May 28th', 'May 17th', 'fbla_essentials', 'Dates', 'NLC Information');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When is the application deadline to be an FBLA National Officer?', 'June 27th', 'May 18th', 'June 10th', 'May 15th', 'fbla_essentials', 'Dates', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When are draft campaign materials due?', 'June 15th', 'June 20th', 'May 31st', 'June 1st', 'fbla_essentials', 'Dates', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When will the candidate briefing sessions take place?', 'June 29th', 'June 21st', 'June 25th', 'June 28th', 'fbla_essentials', 'Dates', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When will national officer training take place?', 'August 2 - 5', 'August 1 - 4', 'July 21 - 24', 'August 6 - 9', 'fbla_essentials', 'Dates', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which is the correct size restriction for a campaign booth?', '10’x10’x10’', '5’x5’x8’', '7’x7’x10’', '10’x10’x8’', 'fbla_essentials', 'Campaigning', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following campaign materials are not allowed?', 'Packaged food', 'Bracelets', 'Necklaces', 'Helium Balloons', 'fbla_essentials', 'Campaigning', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following campaign materials are not allowed?', 'Business Cards', 'Pamphlets', 'Flyers', 'Money', 'fbla_essentials', 'Campaigning', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the maximum amount of money that donated materials and money spent can total?', '$4000', '$500', '$1000', '$2000', 'fbla_essentials', 'Campaigning', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the time limit for campaign speeches?', '4 minutes', '1.5 minutes', '5 minutes', '2 minutes', 'fbla_essentials', 'Campaigning', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When should campaigning take place for President, Secretary, and Treasurer?', 'Anytime during NLC', 'Before NLC', 'As soon as the declaration for candidacy', 'After opening session', 'fbla_essentials', 'Campaigning', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Should you, as a candidate, contact members from other states prior to NLC?', 'Yes, it will increase your chances of success', 'No, it is a waste of time', 'Yes, but only on a large scale', 'No, it is prohibited', 'fbla_essentials', 'Regulations', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What are the consequences of violating campaign regulations?', 'Community service', 'Loss of FBLA membership', 'Loss of ability to compete', 'Disqualification', 'fbla_essentials', 'Regulations', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following resources lists the duties, policies, and the goals of a national officer?', 'National Officer Guideline', 'National Officer Code of Conduct', 'National Officer Code of Regulations', 'National Officer Handbook', 'fbla_essentials', 'Regulations', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What are the consequences of missing the candidate briefing session?', 'Community service', 'Loss of FBLA membership', 'Loss of ability to compete', 'Disqualification', 'fbla_essentials', 'Regulations', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following people will take part in screening candidates during the candidates interview?', 'Current national officers who are running again', 'The candidate's chapter members', 'The candidates legal guardians', 'State advisors', 'fbla_essentials', 'Regulations', 'National Office Candidacy');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How much background information should you give an audience?', 'Don’t give any', 'Enough to give your speech themselves', 'So much that they could have written your speech', 'Just enough to understand you', 'business_skills', 'Audience', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How should you view your audience?', 'As customers', 'As strangers', 'As your enemy', 'As buddies', 'business_skills', 'Audience', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When facing a large audience, what should you change about your presentation?', 'Be less dramatic and humorous', 'Don’t change anything', 'Speak more quietly', 'Be more dramatic and humorous', 'business_skills', 'Audience', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How should you introduce a quotation in a speech?', 'Say “Quote unquote”', 'Apologize for using a quote first', 'Don’t use quotes in a speech', 'Talk about why the quote relates to the topic', 'business_skills', 'Writing Techniques', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How many quotations should you use in a speech?', 'None', 'Half your speech should be quotes', 'Your entire speech should be quotes from other people', 'Not too many', 'business_skills', 'Writing Techniques', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following is the most effective way of using statistics?', 'Apologize before you use the statistic', 'State the numbers and their context directly.', 'Don’t use statistics', 'Word it in a graphic way/compare to known objects', 'business_skills', 'Writing Techniques', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Using humor in a speech is…', 'Risky, and it is uneffective', 'Safe, and it is effective', 'Safe, but it is uneffective', 'Risky, but can be effective', 'business_skills', 'Writing Techniques', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What should you NOT do when using humor in a speech?', 'Make it simple', 'Make sure it relates to the subject', 'Keep it short', 'Laugh at your own joke', 'business_skills', 'Writing Techniques', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What are the effects of humor in a speech?', 'It makes the audience tense', 'It makes the audience stressed', 'It makes you less credible', 'It makes you appear friendly and trustworthy', 'business_skills', 'Writing Techniques', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following words are better for a speech: “Shorten”, “Abbreviate”?', 'Abbreviate', 'Don’t use words in your speech', 'Neither', 'Shorten', 'business_skills', 'Writing Techniques', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following words are better for a speech: “About”, “Approximately”?', 'Approximately', 'Don’t use words in your speech', 'Neither', 'About', 'business_skills', 'Writing Techniques', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('In which of the following scenarios would repetition be most effective?', 'When you forget the rest of your speech', 'When your speech is too short', 'When you want to make your points weaker', 'When stating key ideas', 'business_skills', 'Writing Techniques', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the rule of threes in a speech/presentation?', 'Make every sentences 3 words long', 'Use only 3 words in your speech', 'Make your speech 3 minutes long', 'Organize topics, ideas, or concepts into 3 sections', 'business_skills', 'Writing Techniques', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Approximately how long do you have to get the attention of your audience before you lose it?', '5 seconds', '2 minutes', '4 minutes', '30 seconds', 'business_skills', 'General', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What should you not do in a conclusion?', 'Connect the points in your speech', 'Summarise your points', 'Leave a strong message', 'Bring up new material', 'business_skills', 'General', 'Public Speaking');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('The best way to depict a future prediction is by using a: ', 'bar chart ', 'histogram ', 'pie chart ', 'line chart', 'competitive_events', 'Percents/Probability', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('If 80% > 0.75, then: ', ' 80%is equal to seventy-five hundredths', ' 80% is equal to 3/4 ', ' 4/5 is less than ¾  ', '4/5 is larger than ¾ ', 'competitive_events', 'Percents/Probability', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Twenty-five percent of 1 3/8 = ', '1 1/8 ', '1 ', '32% ', '11/32 ', 'competitive_events', 'Percents/Probability', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is 21 percent of $732? ', '$ 5.37 ', '$578.28 ', '$286.89', '$153.72 ', 'competitive_events', 'Percents/Probability', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('In May, Bill received notice that beginning in June he would receive a 3 percent pay raise. If his monthly gross salary in May was $2,000, how much will his gross salary be in June? ', '$60 ', '$2,600 ', '$600', '$2,060', 'competitive_events', 'Percents/Probability', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('You purchase a car for $1,500. The cost for a title is $150, registration is $75, and sales tax is 8%. What is the total cost for the car? ', '$1,500 ', '$1,725 ', '$1,120', '$1,845  ', 'competitive_events', 'Percents/Probability', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('A cake recipe requires 4 eggs, ½ lflour, ¼ lsugar, and two readymade edible flowers. How much will it cost to make two cakes? Use the following data: eggs = $1.00/dz; flour = $2.50/lb; sugar = $4.50/lb; and flowers = 5 cents each. ', '$2.80 ', '$6.41 ', '$2.81', '$5.61 ', 'competitive_events', 'Basic Maths', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Find the answer for 51.04 * 0.00001', '5.404 ', '0.05404 ', '0.0005404 ', '0.0005104', 'competitive_events', 'Basic Maths', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('The area of a circle with a diameter of 6 inches is approximately: ', ' 28.26 in', ' 56.54 in', '56.54 in²', ' 28.26 in² ', 'competitive_events', 'Basic Maths', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Determine the average of 90, 66, 84, 72, 98. ', '80 ', '90 ', '102', '82', 'competitive_events', 'Basic Maths', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Mary has just charged $1,000 on her credit carId she pays only the interest that accumulates after one month, how much interest would she pay if the APR is 24 percent? ', '$240 ', '$10', '$15.75', '$20 ', 'competitive_events', 'Interest', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES(' Find the amount due on a loan of $25,000 borrowed for 5 years at 6 1/2 percent simple interest. ', '$8,125 ', '$26,625 ', '$1,625 ', '$33,125 ', 'competitive_events', 'Interest', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES(' Calculate the amount to be repaid on a principal of $1,750 at 10% annually. ', '$17.50 ', '$175', '$1700', '$1925 ', 'competitive_events', 'Interest', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Johnson Construction Supply Company allows trade discounts of 20% to customers from the North Division of the state. Calculate the net selling price on building supplies of $850.00. ', '$800 ', '$1020 ', '$170 ', '680', 'competitive_events', 'Interest', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Jim bought a new refrigerator for $1,050.00 on February 1. He purchased it from Siemer's Appliances, which gives customers a cash discount of 3/10, n/30. What is the amount due if Jim pays on February 20? ', '$31.50 ', '$1,050.00 ', '$972.00 ', '$1,018.50 ', 'competitive_events', 'Interest', 'Intro to Financial Maths');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is a snapshot of a system state that is used for a system restore?', 'Microsoft's current file system, faster, supports larger drives, and supports encryption, but is incompatible with other operating systems', '  Restart the program', '  Small Computer System Interface, the major standard of serial ports', '  Restore point', 'competitive_events', 'Security', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the most important activity that users must do when handling sensitive data?', '  Attract the toner from the drum to the paper.', '  Did you scan the file for viruses before opening it?', '  User ID with a reusable password', '  Log off of their workstations when they leave', 'competitive_events', 'Security', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the most common form of identification and authentication?', '  Problem with motherboard', '  Log off of their workstations when they leave', '  Product Activation', '  User ID with a reusable password', 'competitive_events', 'Security', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is CMOS?', 'Unshielded twisted pair, the most common type of networking cable, includes most phone and Ethernet lines', 'A section of a hard drive dedicated to software to be loaded when the the computer is turned on, like BIOS', 'Shielded twisted pair, cable is protected with metallic substance to reduce interference, rare due to expense', 'A battery-powered memory chip in your computer that stores start-up information. BIOS uses this information when starting your computer.', 'competitive_events', 'PC Components', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('How many bits make up a byte?', '  1000000000000', '  802.11', '  127', '  8', 'competitive_events', 'PC Components', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the term for simulating memory using hard drive space?', '  HKEY_LOCAL_MACHINE/SYSTEM', '  Microprocessor', '  Direct download, disk', '  Virtual memory', 'competitive_events', 'PC Components', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is a major security feature introduced in XP?', '  The program file is corrupt or deleted', '  Displays list of programs associated with file types', '  Install a bidirectional cable', '  Digital Certificates, verify identity of creators', 'competitive_events', 'Operating Systems', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which version of Windows integrated consumer and business features into one OS with different versions?', '  Allow- Read and Execute', '  RAM', '  Allow- Modify', '  XP', 'competitive_events', 'Operating Systems', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('8. What does Windows command assoc do?', '  First line of processors to be totally 64-bit', '  Problem with keyboard', '  Speed up HDD access by using a part of RAM to cache data', '  Displays list of programs associated with file types', 'competitive_events', 'Operating Systems', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What key would you press in Emergency Repair Disk to restore the registry?', '  Virtual memory', '  Allow- Write', '  DDR2 SDRAM', '  F (fast repair)', 'competitive_events', 'Operating Systems', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which standard defines wireless networking?', '802.11b (Wi-Fi)', '35-40 degrees C (95-104 F)', '5 meters', '802.11', 'competitive_events', 'Networking', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is a network topology?', '  When devices are connected to each other in varying ways', '  Microsoft MS-DOS CD-ROM Extensions', '  The second cache the CPU uses, sometimes as an expansion', '  The structure of a computer network', 'competitive_events', 'Networking', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What does ISDN stand for?', 'Displays a text file', ' Problem with printer', ' Uniformly charges the drum to reset it between printouts.', ' Integrated Services Digital Network ', 'competitive_events', 'Networking', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What does FDDI stand for?', '  The structure of a computer network', '  Microsoft MS-DOS CD-ROM Extensions', '  Problem with video adapter', '  Fiber Distributed Data Interface', 'competitive_events', 'Networking', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the most likely consequence of a sudden power outage?', 'Virtual memory', 'Identity theft', 'Authentication', 'Lost data', 'competitive_events', 'Safety', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('When sitting a workstation, what angle should a user's forearm be to their body?', '  1-11', '  XGA', '  RAM', '  90', 'competitive_events', 'Safety', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is STP?', 'Wi-Fi Protected Setup, a one-touch Wi-Fi security protocol', 'Wi-Fi Protected Access, a newer security algorithm for Wi-Fi.', 'Master Boot Record, a special type of boot sector data that sorts and verifies drive partitions', 'Shielded twisted pair, cable is protected with metallic substance to reduce interference, rare due to expense .', 'competitive_events', 'Safety', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the super high 4:3 monitor resolution, defined by 1600x1200?', '  CHKDSK', '  Yes.', '  User ID with a reusable password', '  UXGA', 'competitive_events', 'Devices', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is control set data?', 'Heats up and melts the toner unto the surface of the paper.', 'An older file system, can be read and written to by almost any operating system', 'When devices are connected to two other devices on either side, creating a circle', 'Data of system configuration information such as device drivers and services.', 'competitive_events', 'Devices', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the best way to fix the problem of having a bidirectional printer and driver but unidirectional cable? ', 'HKEY_LOCAL_MACHINE/SYSTEM', 'Identity theft', 'Log off of their workstations when they leave', 'Install a bidirectional cable', 'competitive_events', 'Printers/Scanners', 'Computer Problem Solving');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('A "201 " error at system startup means what?', 'bad hard disk system', 'bad floppy drive', 'bad system board', 'bad memory', 'competitive_events', 'Hardware', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('The first thing you can do to increase the available conventional memory is', ' rearrange the loading order of the drivers.', ' remove DOS.', 'load all device drivers into UMBS.', 'add DOS-HIGH to the CONFIG.SYS.', 'competitive_events', 'Hardware', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('  Before you install a new device in a functioning computer, you should', 'disassemble the computer.', 'install DOS.', ' install MSD.', 'determine the computer's available resources.', 'competitive_events', 'Hardware', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following is true of master/slave hard drive configurations?', 'Do not mix ATA and IDE drives on a single controller.', 'The primary controller must contain drives that are technologically similar to or newer than drives on the secondary controller.', 'Do not install drives on the secondary controller without a primary slave present.', 'Do not configure a hard drive to be CD-ROM drive's slave.', 'competitive_events', 'Hardware', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('A customer is complaining that the power in the office sometimes surges, sometimes causes blackouts, and has EMI. What single device can you recommend to help the most in this situation?', 'a suppressor', 'a backup battery', 'a noise filter', ' a UPS', 'competitive_events', 'Hardware', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which type of signal degrades the most over longer distances?', 'analog', 'serial', 'parallel', 'Digital', 'competitive_events', 'Networking', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('  What devices transfer packets across multiple networks and use tables to store network addresses to determine the best destination?', 'brouters', 'gateways', 'bridges', 'routers', 'competitive_events', 'Networking', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following statements best describes an IP address?', 'IP addresses are composed of four numbers, each of which is between 1 and 256. These numbers can be automatically provided or assigned by a system administrator.', ' An IP address is a set of three numbers, each of which must be from 0 to 255. An IP address is a unique name that identifies the computer within a network. This name can be automatically provided or assigned by a system administrator.', 'An IP address is no more than your dial-up telephone number.', 'An IP address is a set of four numbers, each of which must be from 0 to 255. These numbers can be automatically provided or assigned by a system administrator.', 'competitive_events', 'Networking', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What was the first 32-bit preemptive multitasking system?', 'Windows 3', 'Windows 2', 'Windows 1', 'Windows 95', 'competitive_events', 'Operating Systems', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which of the following is not a part of the graphical phase of Windows 2000 Setup?', 'networking setting/installing components', 'fate and time settings', 'regional setting', 'partitioning the hard drive', 'competitive_events', 'Operating Systems', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('Which Windows error is caused by an application being "greedy" and taking memory away from other programs?', 'System Fault', 'Memory Protection Fault', 'General System Error', 'General Protection Fault', 'competitive_events', 'Operating Systems', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('What is the disadvantage of FAT32?', 'You don't have to create multiple partitions.', 'It is compatible with all versions of DOS and other operating systems.', 'It supports drives up to 2 terabytes.', 'It's not compatible with older versions of DOS or with Windows 3.x and Windows 95 operating systems.', 'competitive_events', 'Software', 'Intro to IT');");
        initialize_questions.add("INSERT INTO " + TABLE_NAME + "("+ KEY_QUESTION + ", " + KEY_CHOICE_ONE + "," + KEY_CHOICE_TWO + "," + KEY_CHOICE_THREE + "," + KEY_CHOICE_CORRECT + "," + KEY_CATEGORY + "," + KEY_SUBCATEGORY + "," + KEY_TOPIC + ")" + " VALUES('In order to delete and/or replace system files, which command must you use to remove the hidden, system, ad read-only attributes on the file before you replace the file?', 'DELETE', 'ATTRIB', 'UNDELETE', 'ERASE', 'competitive_events', 'Functions', 'Intro to IT');");
    }
    //----------------------------------------------

    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        this.ctx = context;
    }

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

    //ADD, WRITE, DELETE, GET OPERATIONS FOR DATABASE

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


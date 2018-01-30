package com.example.jatinshad.cricquiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class game extends AppCompatActivity {

    //ArrayList<String> arrayQuestion = new ArrayList<>();
    //ArrayList<String> arrayAnswer = new ArrayList<>();
    TextView correct;
    TextView question,final_score,timer_text;
    Button button1,button2,button3,button4;
    int e=0,correct_ans,gameOver=0;
    int t,j,check=0,i=0,no_of_questions=0;
    int[] a={-123,-123,-123,-123,-123,-123,-123,-123,-123,-123,-123,-123,-123,-123,-123,-123,-123,-123,-123,-123};
    Random ran = new Random();




    int check_e(int e)
    {
        check=0;
       for(j=0;j<20;j++)
       {
           if(e==a[j])
           {
               check=-1;

           }

       }

        if(check!=-1)
       {

           a[i]=e;
           i++;
           return 1;
       }
       else
        {
            return 0;
        }
    }

    String quest[] =
            {"Who holds the record of most number of catches in test match cricket as a fielder?",
                    "Which of the following player has hit the first ball of a test match for a six?",
                    "Which Indian batsman holds the record of batting on all 5 days in a test match?",
            "Which batsman of the following holds the record for the highest individual score in test matches?",
            "Who has scored the most number of runs in T20 internationals?",
            "Which bowler holds the record of most number of wickets in a single test match?",
            "Alongside Rohit Sharma, which batsman holds the record of joint fastest hundred in a T20 international?",
            "Which batsman has played the most number of test matches after Sachin Tendulkar?",
            "Which substitute fielder holds the record of most number of catches(4) in a test match innings?",
            "Which wicketkeeper holds the record for most number of dismissals in test matches?",
            "Which bowler of the following holds the record of taking more number of wickets than the runs they have scored in test cricket?",
                    "Which player has captained his team for more than 100 test matches?",
                    "Who is the highest wicket taker for India in test matches?",
                    "Who has the most number of centuries in T20 cricket?",
                    "Which player has played for only one team in the history of IPL?",
                    "Who is the youngest player to make his test debut?",
                    "Which player has played the most number of T20 internationals?",
                    "Which player has the most runs in IPL history till the 2017 edition?",
                    "Which player has lead his team to most number of wins in IPL matches?",
                    "Which player has the most number of wickets as a captain in a T20 international match?"
            };
    String answ[][] =
            {{"Rahul Dravid", "Steve Waugh", "M Jayawardene", "Ricky Ponting"},
                    {"Chris Gayle", "V Sehwag", "David Warner", "T Dilshan"},
                    {"Ravi shastri","Don Bradman","Rahul Dravid","Sachin Tendulkar"},
                    {"Brian Lara","Rohit Sharma","Matthew Hayden","Michael Clarke"},
                    {"B McCulum","Virat Kohli","Chris Gayle","T Dilshan"},
                    {"Jim Laker","Anil Kumble","Glenn McGrath","Shane Warne"},
                    {"David Miller","Chris Gayle","B McCullum","Colin Munro"},
                    {"Ricky Ponting","Rahul Dravid","Jacques Kallis","Alan Border"},
                    {"Younus Khan","Jonty Rhodes","Shaun Marsh","V Sehwag"},
                    {"Mark Boucher","Adam Gilchrist","MS Dhoni","Ian Healy"},
                    {"Chris Martin","Glenn McGrath","Munaf Patel","Curtly Ambrose"},
                    {"Graeme Smith","Ricky Ponting","Steve Waugh","Daniel Vettori"},
                    {"Kapil Dev","Harbhajan Singh","Zaheer Khan","R Ashwin"},
                    {"Colin Munro","B McCullum","Virat Kohli","Chris Gayle"},
                    {"Virat Kohli","AB De Villiers","MS Dhoni","Rohit Sharma"},
                    {"Hasan Raza","Aaqib Javed","Parthiv Patel","Piyush Chawla"},
                    {"Shahid Afridi","MS Dhoni","Umar Gul","JP Duminy"},
                    {"Suresh Raina","Virat Kohli","Rohit Sharma","David Warner"},
                    {"MS Dhoni","Gautam Gambhir","David Warner","Virat Kohli"},
                    {"Shahid Afridi","Daniel Vettori","Darren Sammy","Johan Botha"}
            };


    public void generateQuestion()
    {
       e=ran.nextInt(19);
        Log.i(" e is ", Integer.toString(e));
        while(check_e(e)!=1)
        {e=ran.nextInt(19);}

    if(e<=19) {
        int x=ran.nextInt(4);

        t=x;
        x=0;
        String stri;
        stri=answ[e][0];
        answ[e][0]=answ[e][t];
        answ[e][t]=stri;
        question.setText(quest[e]);
        button1.setText(answ[e][0]);
        button2.setText(answ[e][1]);
        button3.setText(answ[e][2]);
        button4.setText(answ[e][3]);
    }
    else
    {
        Intent intent = new Intent(getApplicationContext(),GameFinish.class);
        intent.putExtra("Score ",correct_ans);
        startActivity(intent);
    }
       // e=e+1;


    }

    public void answer(View view)
    {
        /*int x=ran.nextInt(4);
        int t;
        t=x;
        x=0;
        String stri;
        stri=answ[e][0];
        answ[e][0]=answ[e][t];
        answ[e][t]=stri;
        */
        if(view.getTag().equals(String.valueOf(t)))
        {
            correct.setText("Congratulations, your answer is correct !!");
            //generateQuestion(e+1);
            if(gameOver!=1) {
                correct_ans++;
            }//e=e+1;
            no_of_questions++;
            if(no_of_questions<=9){
            generateQuestion();}
            else{
                Intent intent = new Intent(getApplicationContext(), GameFinish.class);
                intent.putExtra("Score ", correct_ans);
                gameOver=1;
                startActivity(intent);
            }


        }
        else
        {
            correct.setText("Sorry, your answer is incorrect !!");
            //generateQuestion(e+1);
            //e=e+1;
            no_of_questions++;
            if(no_of_questions<=9) {
                generateQuestion();
            }
            else{
                Intent intent = new Intent(getApplicationContext(), GameFinish.class);
                intent.putExtra("Score ", correct_ans);
                gameOver=1;
                startActivity(intent);
            }


        }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



        question = (TextView) findViewById(R.id.textView);

        correct = (TextView) findViewById(R.id.corectQuestion);

        final_score=(TextView) findViewById(R.id.finsl_score);

        timer_text=(TextView) findViewById(R.id.timer_text);


        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);

        /*arrayQuestion.add("Who holds the record of most number of catches in test match cricket as a fielder?");
        question.setText(arrayQuestion.get(0));

        arrayAnswer.add("Rahul Dravid");
        arrayAnswer.add("Steve Waugh");
        arrayAnswer.add("Sachin Tendulkar");
        arrayAnswer.add("Mahela Jayawardene");

        button1.setText(arrayAnswer.get(0));
        button2.setText(arrayAnswer.get(1));
        button3.setText(arrayAnswer.get(2));
        button4.setText(arrayAnswer.get(3));

        */

            //generateQuestion(e+1);

        generateQuestion();

        new CountDownTimer(60100,1000) {
            @Override
            public void onTick(long l){
                timer_text.setText("Time remaining is : "+l/1000+"s");

            }

            @Override
            public void onFinish() {

                if(gameOver!=1) {
                    Intent intent = new Intent(getApplicationContext(), GameFinish.class);
                    intent.putExtra("Score ", correct_ans);
                    startActivity(intent);

                    //final_score.setText("Your final score is "+Integer.toString(correct_ans));
                }
            }
        }.start();


    }
}

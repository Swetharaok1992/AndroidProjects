package com.example.swetharao.finalproject;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by swetha rao on 4/23/2017.
 */

public class SQL extends SQLiteOpenHelper {
    int DB_VERSION = 1;
    String DB_NAME = "projectdb10.db";
    Context context;

    public SQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        // Store the context for later use
        this.context = context;
        DB_VERSION = version;
        DB_NAME = name;
        //check if db exists, if not it calls onCreate If it does exists then it checks
        //the version. If the version is different then it calls the onUpgrade.
    }
    //if you want just basic, use this constructor instead of the above
    // public SQL (Context context)
    //{
    //	super(context, DB_NAME,null,DB_VERSION);
    // 	this.context = context;
    //}


    @Override
    public void onCreate(SQLiteDatabase db) {
        String st1="sd11",st2="sd12",st3="sd13",st4="sd14",st5="sd15",st6="sd16";
        String l1="miso",l2="minestron",l3="ajiaco",l4="d",l5="gazpacho",l6="onion";
        String t1="a",t2="c",t3="ch",t4="ch",t5="chicken",t6="p";
        String dt1="s1",dt2="s2",dt3="s3",dt4="s4",dt5="s5",dt6="s6";
        String lb1="th",lb2="fnm",lb3="beef",lb4="beer",lb5="prosciutto",lb6="smoked";
        String mc1="m11",mc2="m12",mc3="m13",mc4="m14",mc5="m15",mc6="m16";

        db.execSQL("CREATE TABLE sides ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL, "
                + "img TEXT NOT NULL)"
        );

        Resources res = context.getResources();
        int rd1 = res.getIdentifier(st1,"drawable",context.getPackageName());
        int rd2 = res.getIdentifier(st2,"drawable",context.getPackageName());
        int rd3 = res.getIdentifier(st3,"drawable",context.getPackageName());
        int rd4 = res.getIdentifier(st4,"drawable",context.getPackageName());
        int rd5 = res.getIdentifier(st5,"drawable",context.getPackageName());
        int rd6 = res.getIdentifier(st6,"drawable",context.getPackageName());

        db.execSQL(("Insert into sides(name,cost,img)values('Coleslaw','5$','" + rd1 + "')"));
        db.execSQL(("Insert into sides(name,cost,img)values('Potato Salad','2$','" + rd2 + "')"));
        db.execSQL(("Insert into sides(name,cost,img)values('French fries','1.5$','" + rd3 + "')"));
        db.execSQL(("Insert into sides(name,cost,img)values('Macaroni and Cheese','3$','" + rd4 + "')"));
        db.execSQL(("Insert into sides(name,cost,img)values('Garden asparagus','1$','" + rd5 + "')"));
        db.execSQL(("Insert into sides(name,cost,img)values('Pasta salad','5$','" + rd6 + "')"));


        db.execSQL("CREATE TABLE soups ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL,"
                + "img TEXT NOT NULL)"
        );
        int sid1 = res.getIdentifier(l1,"drawable",context.getPackageName());
        int sid2 = res.getIdentifier(l2,"drawable",context.getPackageName());
        int sid3 = res.getIdentifier(l3,"drawable",context.getPackageName());
        int sid4 = res.getIdentifier(l4,"drawable",context.getPackageName());
        int sid5 = res.getIdentifier(l5,"drawable",context.getPackageName());
        int sid6 = res.getIdentifier(l6,"drawable",context.getPackageName());

        db.execSQL(("Insert into soups(name,cost,img)values('Miso soup','5$','" + sid1 + "')"));
        db.execSQL(("Insert into soups(name,cost,img)values('Minestrone','2$','" + sid2 + "')"));
        db.execSQL(("Insert into soups(name,cost,img)values('Ajiaco','1.5$','" + sid3 + "')"));
        db.execSQL(("Insert into soups(name,cost,img)values('Borscht','3$','" + sid4 + "')"));
        db.execSQL(("Insert into soups(name,cost,img)values('Gazpacho','1$','" + sid5 + "')"));
        db.execSQL(("Insert into soups(name,cost,img)values('French onion soup','5$','" + sid6 + "')"));

        db.execSQL("CREATE TABLE starters ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL, "
                + "img TEXT NOT NULL)"
        );
        int sd1 = res.getIdentifier(t1,"drawable",context.getPackageName());
        int sd2 = res.getIdentifier(t2,"drawable",context.getPackageName());
        int sd3 = res.getIdentifier(t3,"drawable",context.getPackageName());
        int sd4 = res.getIdentifier(t4,"drawable",context.getPackageName());
        int sd5 = res.getIdentifier(t5,"drawable",context.getPackageName());
        int sd6 = res.getIdentifier(t6,"drawable",context.getPackageName());

        db.execSQL(("Insert into starters(name,cost,img)values('Kakori Kebabs','5$','" + sd1 + "')"));
        db.execSQL(("Insert into starters(name,cost,img)values('Stir Fried Chilli Chicken','2$','" + sd2 + "')"));
        db.execSQL(("Insert into starters(name,cost,img)values('Microwave Paneer Tikkas','1.5$','" + sd3 + "')"));
        db.execSQL(("Insert into starters(name,cost,img)values('Aloo and Dal Ki Tikki','3$','" + sd4 + "')"));
        db.execSQL(("Insert into starters(name,cost,img)values('Cheese Balls','1$','" + sd5 + "')"));
        db.execSQL(("Insert into starters(name,cost,img)values('Chicken Satay','5$','" + sd6 + "')"));


        db.execSQL("CREATE TABLE Desserts ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL, "
                + "img TEXT NOT NULL)"
        );
        int d1 = res.getIdentifier(dt1,"drawable",context.getPackageName());
        int d2 = res.getIdentifier(dt2,"drawable",context.getPackageName());
        int d3 = res.getIdentifier(dt3,"drawable",context.getPackageName());
        int d4 = res.getIdentifier(dt4,"drawable",context.getPackageName());
        int d5 = res.getIdentifier(dt5,"drawable",context.getPackageName());
        int d6 = res.getIdentifier(dt6,"drawable",context.getPackageName());

        db.execSQL(("Insert into Desserts(name,cost,img)values('Sopapillas','5$','" + d1 + "')"));
        db.execSQL(("Insert into Desserts(name,cost,img)values('Churros','2$','" + d2 + "')"));
        db.execSQL(("Insert into Desserts(name,cost,img)values('Tiramisu','1.5$','" + d3 + "')"));
        db.execSQL(("Insert into Desserts(name,cost,img)values('Almond Cookies','3$','" + d4 + "')"));
        db.execSQL(("Insert into Desserts(name,cost,img)values('Castle Pudding','1$','" + d5 + "')"));
        db.execSQL(("Insert into Desserts(name,cost,img)values('Pavlova','5$','" + d6 + "')"));

        db.execSQL("CREATE TABLE Main_course ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL,"
                + "img TEXT NOT NULL)"
        );
        int rid1 = res.getIdentifier(mc1,"drawable",context.getPackageName());
        int rid2 = res.getIdentifier(mc2,"drawable",context.getPackageName());
        int rid3 = res.getIdentifier(mc3,"drawable",context.getPackageName());
        int rid4 = res.getIdentifier(mc4,"drawable",context.getPackageName());
        int rid5 = res.getIdentifier(mc5,"drawable",context.getPackageName());
        int rid6 = res.getIdentifier(mc6,"drawable",context.getPackageName());

        db.execSQL(("Insert into Main_course(name,cost,img)values('Beef Enchiladas','5$','" + rid1 + "')"));
        db.execSQL(("Insert into Main_course(name,cost,img)values('Beer and Brown Sugar Kielbasa ','2$','" + rid2 + "')"));
        db.execSQL(("Insert into Main_course(name,cost,img)values('Sauerkraut','1.5$','" + rid3 + "')"));
        db.execSQL(("Insert into Main_course(name,cost,img)values('Coconut with Mango Dipping Sauce','3$','" + rid4 + "')"));
        db.execSQL(("Insert into Main_course(name,cost,img)values('Crab Cakes with Remoulade Sauce','1$','" + rid5 + "')"));
        db.execSQL(("Insert into Main_course(name,cost,img)values('Frito Pie','5$','" + rid6 + "')"));

        db.execSQL("CREATE TABLE chef_special ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL,"
                + "img TEXT NOT NULL )"
        );
        int c1 = res.getIdentifier(lb1,"drawable",context.getPackageName());
        int c2 = res.getIdentifier(lb2,"drawable",context.getPackageName());
        int c3 = res.getIdentifier(lb3,"drawable",context.getPackageName());
        int c4 = res.getIdentifier(lb4,"drawable",context.getPackageName());
        int c5 = res.getIdentifier(lb5,"drawable",context.getPackageName());
        int c6 = res.getIdentifier(lb6,"drawable",context.getPackageName());

        db.execSQL(("Insert into chef_special(name,cost,img)values('Pretzel Brownie Bar','5$','" + c1 + "')"));
        db.execSQL(("Insert into chef_special(name,cost,img)values('Panko-Coated Chicken Schnotzel ','2$','" + c2 + "')"));
        db.execSQL(("Insert into chef_special(name,cost,img)values('Chilled Spring Pea Soup','1.5$','" + c3 + "')"));
        db.execSQL(("Insert into chef_special(name,cost,img)values('Smoked Salmon Crisps','3$','" + c4 + "')"));
        db.execSQL(("Insert into chef_special(name,cost,img)values('August Chopped Salad','1$','" + c5 + "')"));
        db.execSQL(("Insert into chef_special(name,cost,img)values('Fig-and-Prosciutto Falatbreads','5$','" + c6 + "')"));

        db.execSQL("CREATE TABLE MENU ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "Uname TEXT NOT NULL, "
                + "name TEXT NOT NULL,"
                + "cost TEXT NOT NULL,"
                + "qty TEXT NOT NULL,"
                + "date TEXT NOT NULL)"
        );
        String st11 = "sd1", st12 = "sd2", st13 = "sd3", st14 = "sd4", st15 = "sd5", st16 = "sd6";
        String s1 = "dt1", s2 = "dt2", s3 = "dt3", s4 = "dt4", s5 = "dt5", s6 = "dt6";
        String mc11 = "m1", mc12 = "m2", mc13 = "m3", mc14 = "m4", mc15 = "m5", mc16 = "m6";
        String m1 = "w1", m2 = "w2", m3 = "w3", m4 = "w4", m5 = "w5", m6 = "w6",m7 = "w7", m8 = "w8", m9 = "w9";

        db.execSQL("CREATE TABLE COCKTAILS ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL, "
                + "img TEXT NOT NULL)"
        );

        Resources res1 = context.getResources();
        int rd11 = res.getIdentifier(st11, "drawable", context.getPackageName());
        int rd12 = res.getIdentifier(st12, "drawable", context.getPackageName());
        int rd13 = res.getIdentifier(st13, "drawable", context.getPackageName());
        int rd14 = res.getIdentifier(st14, "drawable", context.getPackageName());
        int rd15 = res.getIdentifier(st15, "drawable", context.getPackageName());
        int rd16 = res.getIdentifier(st16, "drawable", context.getPackageName());

        db.execSQL(("Insert into COCKTAILS (name,cost,img)values('FashionedOld','20$','" + rd11 + "')"));
        db.execSQL(("Insert into COCKTAILS(name,cost,img)values('Martinez','10$','" + rd12 + "')"));
        db.execSQL(("Insert into COCKTAILS(name,cost,img)values('Martini','10.35$','" + rd13 + "')"));
        db.execSQL(("Insert into COCKTAILS(name,cost,img)values('Manhattan','20.45$','" + rd14 + "')"));
        db.execSQL(("Insert into COCKTAILS(name,cost,img)values('Brooklyn','10.35$','" + rd15 + "')"));
        db.execSQL(("Insert into COCKTAILS(name,cost,img)values('Daiquiri','15.45$','" + rd16 + "')"));

        db.execSQL("CREATE TABLE CHAMPANGE ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL, "
                + "img TEXT NOT NULL)"
        );


        int d11 = res.getIdentifier(s1,"drawable",context.getPackageName());
        int d12 = res.getIdentifier(s2,"drawable",context.getPackageName());
        int d13 = res.getIdentifier(s3,"drawable",context.getPackageName());
        int d14 = res.getIdentifier(s4,"drawable",context.getPackageName());
        int d15 = res.getIdentifier(s5,"drawable",context.getPackageName());
        int d16 = res.getIdentifier(s6,"drawable",context.getPackageName());

        db.execSQL(("Insert into CHAMPANGE(name,cost,img)values('Dom Perignon ','15$','" + d11 + "')"));
        db.execSQL(("Insert into CHAMPANGE(name,cost,img)values('Veuve Clicquot ','20$','" + d12 + "')"));
        db.execSQL(("Insert into CHAMPANGE(name,cost,img)values('Ace of Spades ','22.9$','" + d13 + "')"));
        db.execSQL(("Insert into CHAMPANGE(name,cost,img)values('Bollinger','6$','" + d14 + "')"));
        db.execSQL(("Insert into CHAMPANGE(name,cost,img)values('Cristal Champagne ','20.8$','" + d15 + "')"));
        db.execSQL(("Insert into CHAMPANGE(name,cost,img)values('Krug Champagne ','25.8$','" + d16 + "')"));

        db.execSQL("CREATE TABLE SODAS("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL,"
                + "img TEXT NOT NULL)"
        );
        int rid11 = res.getIdentifier(mc11,"drawable",context.getPackageName());
        int rid12 = res.getIdentifier(mc12,"drawable",context.getPackageName());
        int rid13 = res.getIdentifier(mc13,"drawable",context.getPackageName());
        int rid14 = res.getIdentifier(mc14,"drawable",context.getPackageName());
        int rid15 = res.getIdentifier(mc15,"drawable",context.getPackageName());
        int rid16 = res.getIdentifier(mc16,"drawable",context.getPackageName());

        db.execSQL(("Insert into SODAS(name,cost,img)values('Fanta','5$','" + rid11 + "')"));
        db.execSQL(("Insert into SODAS(name,cost,img)values('coca-cola ','2$','" + rid12 + "')"));
        db.execSQL(("Insert into SODAS(name,cost,img)values('crush','1.5$','" + rid13 + "')"));
        db.execSQL(("Insert into SODAS(name,cost,img)values('Mountain-Dew','3$','" + rid14 + "')"));
        db.execSQL(("Insert into SODAS(name,cost,img)values('Surge','1$','" + rid15 + "')"));
        db.execSQL(("Insert into SODAS(name,cost,img)values('Fresca','5$','" + rid16 + "')"));

        db.execSQL("CREATE TABLE REDWINES ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL,"
                + "img TEXT NOT NULL)"
        );
        int r1 = res.getIdentifier(m1,"drawable",context.getPackageName());
        int r2 = res.getIdentifier(m2,"drawable",context.getPackageName());
        int r3 = res.getIdentifier(m3,"drawable",context.getPackageName());


        db.execSQL(("Insert into REDWINES(name,cost,img)values('Gamay','15$','" + r1 + "')"));
        db.execSQL(("Insert into REDWINES(name,cost,img)values('Nebbiolo','12$','" + r2 + "')"));
        db.execSQL(("Insert into REDWINES(name,cost,img)values('Semillon','10.5$','" + r3 + "')"));


        db.execSQL("CREATE TABLE WHITEWINES ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL,"
                + "img TEXT NOT NULL)"
        );

        int r4 = res.getIdentifier(m4,"drawable",context.getPackageName());
        int r5 = res.getIdentifier(m5,"drawable",context.getPackageName());
        int r6 = res.getIdentifier(m6,"drawable",context.getPackageName());
        db.execSQL(("Insert into WHITEWINES(name,cost,img)values('Pinot grigio','13$','" + r4 + "')"));
        db.execSQL(("Insert into WHITEWINES(name,cost,img)values('Grenache','12$','" + r5 + "')"));
        db.execSQL(("Insert into WHITEWINES(name,cost,img)values('Pinot Noir','15$','" + r6 + "')"));



        db.execSQL("CREATE TABLE GRAPEWINES ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "cost TEXT NOT NULL,"
                + "img TEXT NOT NULL)"
        );

        int r7 = res.getIdentifier(m7,"drawable",context.getPackageName());
        int r8 = res.getIdentifier(m8,"drawable",context.getPackageName());
        int r9 = res.getIdentifier(m9,"drawable",context.getPackageName());
        db.execSQL(("Insert into GRAPEWINES(name,cost,img)values('Tempranillo','23$','" + r7 + "')"));
        db.execSQL(("Insert into GRAPEWINES(name,cost,img)values('Sangiovese','22$','" + r8 + "')"));
        db.execSQL(("Insert into GRAPEWINES(name,cost,img)values('Syrah','15$','" + r9 + "')"));

        db.execSQL("CREATE TABLE DRINKS_MENU ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "Uname TEXT NOT NULL, "
                + "name TEXT NOT NULL,"
                + "cost TEXT NOT NULL,"
                + "qty TEXT NOT NULL,"
                + "date TEXT NOT NULL)"
        );
        db.execSQL("CREATE TABLE orders ("
                + "orderId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "userName TEXT NOT NULL, "
                + "nameOfDish TEXT NOT NULL, "
                + "quantity TEXT NOT NULL, "
                + "cost TEXT NOT NULL, "
                + "image TEXT NOT NULL, "
                + "trackId TEXT NOT NULL, "
                + "dateOfOrder DATE NOT NULL)"
        );

        db.execSQL("CREATE TABLE userDetails (" +
                   "userName TEXT NOT NULL," +
                "password TEXT NOT NULL," +
                "emailID TEXT NOT NULL)");

        db.execSQL("CREATE TABLE reviews ("
                + "revId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "userName TEXT NOT NULL, "
                + "reviewText TEXT NOT NULL, "
                + "reviewBar TEXT NOT NULL ) "

        );
        db.execSQL("CREATE TABLE cart ("
                + "orderId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "userName TEXT NOT NULL, "
                + "nameOfDish TEXT NOT NULL, "
                + "quantity TEXT NOT NULL, "
                + "cost TEXT NOT NULL, "
                + "image TEXT NOT NULL, "
                + "dateOfOrder DATE NOT NULL)"
        );
        //better to create a txt file with all the scripts if they become complex
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //erase or upgrade database

    }
}

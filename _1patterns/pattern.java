package patterns;

public class pattern {
    


    public static void main(String args[]){

        for(int i=0;i<4;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }




        char ch='A';

        
        for(int i=0;i<=4;i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }


        //Hollo rectangle
        for (int i =1; i <=5; i++) {
            for(int j=1;j<=5;j++){
                if(i==1 || i==5 || j==1 || j==5)
                System.out.print("*");
                else
                System.out.print(" ");

            }
            System.out.println();
        }


//INVERTED & ROTATED HALF-PYRAMID

            //       *
            //     * * 
            //   * * * 
            // * * * * 
//stars->i and spaces->n-i

            for(int i=1;i<4;i++){
                for(int j=1;j<4-i;j++){
                    System.out.print(" ");
                }
                for(int k=1;k<=i;k++){
                    System.out.print("*");
                }
                System.out.println();
            }




      
//inverted half pyramid with numbers
for (int i =6; i >0; i--) {
    for(int j=1;j<=i-1;j++){
        
        System.out.print(j);

    }
    System.out.println();
}


//Floyd's triangle
int k=1;
for (int i =1; i <=5; i++) {
    for(int j=1;j<=i;j++){
       
        System.out.print(k+" ");
        k++;
       

    }
    System.out.println();
}

//0-1 traingle 

for(int i=1;i<=5;i++){
    for(int j=1;j<=i;j++){
        if((i+j)%2==0){
            System.out.print(1);
        }else{
            System.out.print(0);
        }
    }
    System.out.println();
}


//butterfky 

// *      *
// **    **
// ***  ***
// ********
// ********
// ***  ***
// **    **
// *      *

/* 

for 1st half
stars + space + stars
  i      2(n-i)    i



*/
int l=4;
for(int i=1;i<=l;i++){

    //stars 
    for(int j=1;j<=i;j++){
        System.out.print("*");
    }

    //spaces
    for(int j=1;j<=2*(l-i);j++){
        System.out.print(" ");
    }

    //stars
    for(int j=1;j<=i;j++){
        System.out.print("*");

    }
    System.out.println();
   
    //second half
}

    for(int i=l;i>=1;i--){
        //stars 
    for(int j=1;j<=i;j++){
        System.out.print("*");
    }

    //spaces
    for(int j=1;j<=2*(l-i);j++){
        System.out.print(" ");
    }

    //stars
    for(int j=1;j<=i;j++){
        System.out.print("*");

    }
    System.out.println();
    }




//solid rhombus 

/*/

    *****
   *****
  *****
 *****
*****


*/

for(int i=1;i<=5; i++){
    for(int j=1;j<=5-i;j++){
        System.out.print(" ");
    }
    for(int j=1;j<=5;j++){
       
        System.out.print("*");
    }
    System.out.println();
}



//hollow rhombus

for(int i=1;i<=5;i++){
    for(int j=1;j<=5-i;j++){
        System.out.print(" ");

    }

    //hollow rectangle

    
//     *****
//    *   *
//   *   *
//  *   *
// *****

    for(int j=1;j<=5;j++){
        if(i==1 || i==5 ||j==1||j==5){
            System.out.print("*");
        }else{
            System.out.print(" ");
        }
    }System.out.println();
}


//diamond

//    *       i=1  sp=3  st=1
//   ***      i=2  sp=2  st=3   stars are in odd form 
//  *****     i=3  sp=1  st=5
// *******    i=4  sp=0  st=7
//------------
// *******
//  *****
//   ***
//    *


for(int i=1;i<=4;i++){
    for(int j=1;j<=4-i;j++){
        System.out.print(" ");
    }
    for(int j=1;j<=2*i-1;j++){
        System.out.print("*");
    }
    System.out.println();
}
//for below part
for(int i=4;i>=1;i--){
    for(int j=1;j<=4-i;j++){
        System.out.print(" ");
    }
    for(int j=1;j<=2*i-1;j++){
        System.out.print("*");
    }
    System.out.println();
}


//number pyramid

//     1
//    2 2 
//   3 3 3
//  4 4 4 4
// 5 5 5 5 5

for(int i=1;i<=5;i++){
    for(int j=1;j<=5-i;j++){
        System.out.print(" ");
    }
    for(int j=1;j<=i;j++){
        System.out.print(i+" ");
    }
    System.out.println();
}

//palindromic pattern with numbers 

//     1
//    212
//   32123
//  4321234
// 543212345



for(int i=1;i<=5;i++){
    for(int j=1;j<=5-i;j++){
        System.out.print(" ");
    }
    for(int j=i;j>=1;j--){
        System.out.print(j);
    }
    for(int j=2;j<=i;j++){
        System.out.print(j);
    }
    System.out.println();
}



for(int i=1;i<=5;i++){
    for(int j=1;j<=5-i;j++){
        System.out.print(" ");
    }
    for(int j=1;j<=i;j++){
        System.out.print(j);
    }
    for(int j=i-1;j>=1;j--){
        System.out.print(j);


    }
    System.out.println();


}
       


    }
    
}

    



//  Created by Jack Clark on 29/07/2016.

#include <stdio.h>
#include <math.h>

float area, s;
int a,b,c;

int main(int argc, const char * argv[]) {
    
    printf("Enter sidelengths of triangle: \n");
    scanf("%i %i %i", &a,&b,&c);
    
    s = (a + b + c)/2;
    area = sqrt(s*(s-a)*(s-b)*(s-c));
    
    if (a + b < c || a + c < b || b + c < a){
        printf("Those sidelength cannot form a triangle\n");
    }else{
    printf("Area = %.2f\n", area);
    }
    
    return 0;
}

#include <stdio.h>
#define MINUTE 60
#define M_LITER 1000
#define SENTINEL 5

int get_problem(void);
double get_n_hours(double num_hours);
void get_rate_drop_factor(double *, double *);
void get_kg_rate_conc(double *, double *, double *);
void get_units_conc(double *, double *);
double fig_drops_min(double, double);
double fig_ml_hr(double);
double by_weight(double, double, double);
double by_units(double, double);

int get_problem(void){
	int menu_number;

	printf("GIVEN A MEDICAL ORDER IN                     CALCULATE RATE IN\n\n");/* 0.5 mark */
	printf("(1) ml/hr & tubing drop factor               drops/min\n");
	printf("(2) 1 L for n hr                             ml/ht\n");
	printf("(3) mg/kg/hr & concentration in mg/ml        ml/hr\n");
	printf("(4) units/hr & concentration in units/ml     ml/hr\n");
	printf("(5) QUIT \n");

	scanf("%d",&menu_number);
	
	
	return (menu_number);

}

void get_rate_drop_factor(double *ml_hour, double *drops_ml) 
{
  printf("Please enter the rate in ml/hr and the tubing's drop factor\n");
  scanf("%lf %lf", ml_hour , drops_ml);
} 


double get_n_hours(double num_hours)
{
	  printf("Please enter the number of hours for 1 liter\n");
      scanf("%lf", &num_hours);
      
      return num_hours;
}

void get_kg_rate_conc(double *mg_kg_hour, double *pat_weight, double *mg_ml)
{
	printf("Please enter the , rate in mg/kg/hr, patient's weight in kg, and concentration in mg/ml\n");
    scanf("%lf %lf %lf", mg_kg_hour , pat_weight, mg_ml);
}

void get_units_conc(double *units_hour, double *units_ml)
{
	printf("Please enter the rate in units/hr and concentration in units/ml\n");
    scanf("%lf %lf", units_hour , units_ml);
}

double fig_drops_min(double ml_hour, double drops_ml)
{
	double answer;
	
	answer = (ml_hour*drops_ml)/MINUTE;
	
	if (answer-(int)answer >= 0.5)
	{
        answer = ((int) answer) + 1;
    }
    else
    {
        answer = (int) answer;
    }
	
	
	return answer;
}

double fig_ml_hr(double num_hours)
{
	double answer;
	
	answer = M_LITER/num_hours;
	if (answer-(int)answer >= 0.5)
	{
        answer = ((int) answer) + 1;
    }
    else
    {
        answer = (int) answer;
    }
	return answer;
}

double by_weight(double mg_kg_hour, double pat_weight, double mg_ml)
{
	double answer;
	
	answer = mg_kg_hour * pat_weight / mg_ml;
	if (answer-(int)answer >= 0.5)
	{
        answer = ((int) answer) + 1;
    }
    else
    {
        answer = (int) answer;
    }
	return answer;
}


double by_units(double units_hour, double units_ml)
{
	double answer;
	
	answer = units_hour / units_ml;
	if (answer-(int)answer >= 0.5)
	{
        answer = ((int) answer) + 1;
    }
    else
    {
        answer = (int) answer;
    }
	return answer;
}



int main(void){

 int value;	
 double answer;	    /* return value of functions*/
 double ml_hour;	/* rate in ml/hr*/
 double drops_ml;	/* tubing factor in drops/ml*/
 double mg_kg_hour;	/* rate in mg/kg/hr*/
 double pat_weight;	/* patient's weight in kg*/
 double mg_ml;	    /* concentration in mg/ml*/
 double units_hour;	/* rate in units/hr*/
 double units_ml;	/* concentration in units/ml*/
 double num_hours;	/* number of hours for 1 L to be delivered*/

 value = get_problem();
  
  while( value!=SENTINEL ) {

	switch(value) {

      case 1: 
  
      get_rate_drop_factor(&ml_hour, &drops_ml);
      answer = fig_drops_min(ml_hour , drops_ml);
      printf("Answer (rounded) is: %lf drops/min\n", answer);
      break;
  
      case 2: 
  
      num_hours = get_n_hours(num_hours);
      answer = fig_ml_hr(num_hours);
      printf("Answer (rounded) is: %lf \n", answer);
      break;
  
      case 3: 
      get_kg_rate_conc(&mg_kg_hour , &pat_weight, &mg_ml);
      answer = by_weight(mg_kg_hour, pat_weight, mg_ml);
      printf("Answer (rounded) is: %lf \n", answer);
      break;
  
      case 4: 
      get_units_conc(&units_hour, &units_ml);
      answer = by_units(units_hour , units_ml);
      printf("Answer (rounded) is: %lf \n", answer);
      break;   
                  
      default:
      printf("Wrong input.\n");
}
  value = SENTINEL;
}

}

#include <stdlib.h>
#include <string.h>

// hash table size is not prime - not sure why, maybe it can be changed?
// need to add collision protection

#define HASH_TABLE_SIZE 1057

typedef struct Entry Entry, *EntryPtr;
struct Entry {
  char *string; // the data
  int key; // the key
  int alive; // to indicate if array slot is occupied
};

Entry hash_table[HASH_TABLE_SIZE]; // array of Entries 

void add(char * tag) {
  Entry *currentEntry = (Entry*) malloc(sizeof(Entry)); // creating and mem allocating currentEntry
  //int temp = hashfunction(tag); // converting string to integer
  currentEntry->key = hashfunction(tag) % HASH_TABLE_SIZE; // determining what bin to put entry // div method I think
  currentEntry->string = tag; // storing unconverted string to *string 
  int index = currentEntry->key;
  currentEntry->alive = 1;


  // Linear Probing
  int i = 0;
  while (hash_table[index].alive != 1) {
    if (hash_table[index].alive != 1) 
      hash_table[currentEntry->key] = *currentEntry; // adding entry
    else {
      i++;
      int temp = (currentEntry->key + i) % HASH_TABLE_SIZE;
      hash_table[temp] = *currentEntry;
    }
  }
} // gotta test this section to see if its adding correctly

int hashFunction(char *tag) {
  int len = strlen(tag);
  int i = 0;
  int hashvalue = 0;
  int count = 0;

  for (i = 0; i < len; i++) {
    count++;
    hashvalue += (count * (int)(tag + i));
  }

  return hashvalue;
}





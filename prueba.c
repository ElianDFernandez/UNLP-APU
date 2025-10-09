#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
int main ( void ) {
    int c ;
    pid_t pid ;
    int p = 0;
    printf( " Comienzo . : \ n " ) ;
    for ( c = 0 ; c < 3 ; c++ ) {
        pid = fork ( ) ;
    }
    p++;
    printf ( " Proceso %d\n ",p ) ;
    return 0 ;
}
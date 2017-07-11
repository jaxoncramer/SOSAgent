/*
* Copyright (c) 2012 aaronorosen@gmail.com
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and/or hardware specification
* (the "Work") to deal in the Work without restriction, including
* without limitation the rights to use, copy, modify, merge, publish,
* distribute, sublicense, and/or sell copies of the Work, and to 
* permit persons to whom the Work is furnished to do so, subject to
* the following conditions:  The above copyright notice and this
* permission notice shall be included in all copies or substantial
* portions of the Work.
*
* THE WORK IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
* OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
* HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
* OUT OF OR IN CONNECTION WITH THE WORK OR THE USE OR OTHER DEALINGS
* IN THE WORK.
*/ 


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>
#include <time.h>
#include <sys/socket.h>
#include <netdb.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <sys/wait.h>
#include <signal.h>
#include <ctype.h>
#include <pthread.h>
#include <arpa/inet.h>
#include <poll.h>
#include <fcntl.h>
#include <sys/epoll.h>
#include <sys/time.h>
#include <getopt.h>
#include <uuid/uuid.h>





#include "uthash.h"
#include "common.h"
#include "datatypes.h"
#include "arguments.h"



int get_arguments(options_t *options,  int argc, char **argv) 
{


	/*  struct option { 
	*	 	const char *name; 
	*	 	int has_arg; 
	*		int *flag; 
	*		int val ; 
	*  }
	*/
   memset(options, 0, sizeof(options_t)); 
	struct option long_options[] = {
		{"verbose", 1, 0, VERBOSE}, 
		{"connections", 1, 0, NUM_CONNECTIONS}, 
		{"NonOf", 0, 0, NONOF}, 
		{"logging", 0, 0, LOGGING}, 
		{"protocol", 1, 0, PROTOCOL},
		{"bind-ip", 1, 0, BIND_IP},
		{0,0,0,0}
	}; 

	int c; 
	int option_index = 0; 

	while(1) 
	{
		c = getopt_long(argc, argv, "a:", long_options, &option_index);  
		if( c == -1 )
		{
			break; 
		} 
		switch (c)
		{

			case VERBOSE:
				options->verbose_level = atoi(optarg); 
				break; 

			case NUM_CONNECTIONS:
				options->num_parallel_connections = atoi(optarg); 
				break; 

			case NONOF:
				options->nonOF = TRUE; 
				break; 

			case LOGGING:
				options->logging = TRUE; 
				break;

			case PROTOCOL:
				if(!strcmp(optarg, "tcp")) { 
					options->protocol = TCP;
				}else if(!strcmp(optarg, "sctp")) { 
					options->protocol = SCTP; 
				}else { 
					printf("unsupported protocol %s\n", optarg); 
					exit(1); 
				}
				break;
	
         case BIND_IP:
            strcpy(options->bind_ip, optarg); 
            break;

			default: 
				printf("getopt returned character code 0%o ??\n", c); 
				display_usage(); 
				exit(1); 
		}
	}
	return EXIT_SUCCESS; 
}


void display_usage()
{

}




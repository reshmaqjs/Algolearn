#include<stdio.h>
#include<string.h>
int main ()
{char text[100],pattern[100];
printf("enter some text:");
scanf("%s",text);
printf("enter pattern to find:");
scanf("%s",pattern);
int c,d,e,g=1,tlen,plen,position;
tlen=strlen(text);
plen=strlen(pattern);
if(plen>tlen)
{g=1;}
else
{for(c=0;c<=tlen-plen;c++)
{position=e=c;
for(d=0;d<plen;d++)
{if(pattern[d]==text[e])
{e++;}
else
{break ;}}
if(d==plen)
{g=0;
printf("found at:%d\n",position+1);}}}
if(g==1)
{printf("not found\n");}}


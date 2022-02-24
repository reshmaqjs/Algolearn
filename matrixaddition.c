#include <stdio.h>

int main()
{
  int m, n, p, q, c, d, k, sum = 0;
  int mat1[10][10], mat2[10][10], mat3[10][10];

  printf("Enter number of rows of first matrix\n");
  scanf("%d", &m);
  printf("Enter number of columns of first matrix\n");
  scanf("%d",&n);
  printf("Enter elements of first matrix\n");

  for (c = 0; c <m; c++)
   { for (d = 0; d <n; d++)
      {scanf("%d", &mat1[c][d]);
      }
    }

  printf("Enter number of rows of second matrix\n");
  scanf("%d", &p);
  printf("Enter number of columns of second matrix\n");
  scanf("%d",&q);

  if (!(m== p && n==q))
    {printf("The addition isn't possible.\n");
     }
  else
  {
    printf("Enter elements of second matrix\n");

    for (c = 0; c < p; c++)
      {for (d = 0; d < q; d++)
        {scanf("%d", &mat2[c][d]);
        }
      }

    for (c = 0; c < m; c++) {
      for (d = 0; d < n; d++) {
       mat3[c][d]=  mat1[c][d]+mat2[c][d];
      }
    }

    printf("addition of the matrices:\n");

    for (c = 0; c < m; c++) {
      for (d = 0; d < q; d++)
     {   printf("%d  ", mat3[c][d]);}

      printf("\n");
    }
  }

  return 0;
}
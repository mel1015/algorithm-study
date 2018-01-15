#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>

#define MAX_STACK  1000
#define MAX_PROG  100000
#define MAX_NUM  1000000000
#define MIN_NUM  -1000000000
#define MAX_QRYS  10000

#define ERR 1
#define ERR_WRONG 2


typedef int INT;
typedef long long LL;
typedef int PG(INT);

PG* pgin[MAX_PROG];
INT pgval[MAX_PROG];

INT stack[MAX_STACK];
int stidx, prgidx;


int check_max_stack()
{
	if (stidx >= MAX_STACK)
	{

		exit(ERR_WRONG);
	}
	return 0;
}

int ins_num(INT par)
{
	if (check_max_stack())
		return 1;

	stack[stidx++] = par;
	return 0;
}

int ins_pop(INT par)
{
	if (stidx == 0)
		return 1;

	--stidx;
	return 0;
}

int ins_dup(INT par)
{
	if (check_max_stack())
		return 1;

	stack[stidx] = stack[stidx - 1];
	++stidx;
	return 0;
}

int ins_swp(INT par)
{
	int x;
	if (stidx < 2)
		return 1;

	x = stack[stidx - 1];
	stack[stidx - 1] = stack[stidx - 2];
	stack[stidx - 2] = x;
	return 0;
}

int ins_inv(INT par)
{
	if (stidx < 1)
		return 1;

	stack[stidx - 1] = -stack[stidx - 1];
	return 0;
}

int ins_oper(LL op(LL, LL))
{
	LL x;
	if (stidx < 2)
		return 1;

	x = op(stack[stidx - 2], stack[stidx - 1]);
	if (x < MIN_NUM || x > MAX_NUM)
		return 1;

	stack[stidx - 2] = (INT)x;
	--stidx;
	return 0;
}

LL op_add(LL a, LL b)
{
	return a + b;
}
LL op_sub(LL a, LL b)
{
	return a - b;
}
LL op_mul(LL a, LL b)
{
	return a * b;
}
LL op_div(LL a, LL b)
{
	if (b == 0)
		return MAX_NUM + 1;
	if (b < 0)
		return op_div(-a, -b);

	return (a < 0) ? -(-a / b) : a / b;
}
LL op_mod(LL a, LL b)
{
	if (b == 0)
		return MAX_NUM + 1;
	if (b < 0)
		b = -b;

	return (a < 0) ? -(-a % b) : a % b;
}

int ins_add(INT par)
{
	return ins_oper(op_add);
}
int ins_sub(INT par)
{
	return ins_oper(op_sub);
}
int ins_mul(INT par)
{
	return ins_oper(op_mul);
}
int ins_div(INT par)
{
	return ins_oper(op_div);
}
int ins_mod(INT par)
{
	return ins_oper(op_mod);
}


int read_end()
{
	int c = getchar();

	if (c == '\r')
		c = getchar();

	return (c == '\n') ? 0 : ERR;
}

int read_num(INT *n)
{
	LL x = 0;
	int c = getchar();

	if (!isdigit(c))
		return ERR;

	while (isdigit(c))
	{
		x = x * 10 + c - '0';
		if (x > MAX_NUM)
			return ERR;
		c = getchar();
	}
	ungetc(c, stdin);
	*n = (INT)x;
	return 0;
}

int read_program()
{
	prgidx = 0;
	for (;;)
	{
		int c1 = getchar();
		int c2 = getchar();
		int c3 = getchar();
		if (c1 == 'E' && c2 == 'N' && c3 == 'D')
		{
			return read_end();
		}
		if (prgidx == MAX_PROG)
			return ERR_WRONG;

		if (c1 == 'N' && c2 == 'U' && c3 == 'M')
		{
			if (getchar() != ' ')
				return ERR;
			if (read_num(pgval + prgidx))
				return ERR;
			if (read_end())
				return ERR;
			pgin[prgidx++] = ins_num;
			continue;
		}
		if (read_end())
			return ERR;
		if (c1 == 'P' && c2 == 'O' && c3 == 'P')
		{
			pgin[prgidx++] = ins_pop;
			continue;
		}
		if (c1 == 'D' && c2 == 'U' && c3 == 'P')
		{
			pgin[prgidx++] = ins_dup;
			continue;
		}
		if (c1 == 'S' && c2 == 'W' && c3 == 'P')
		{
			pgin[prgidx++] = ins_swp;
			continue;
		}
		if (c1 == 'I' && c2 == 'N' && c3 == 'V')
		{
			pgin[prgidx++] = ins_inv;
			continue;
		}
		if (c1 == 'A' && c2 == 'D' && c3 == 'D')
		{
			pgin[prgidx++] = ins_add;
			continue;
		}
		if (c1 == 'S' && c2 == 'U' && c3 == 'B')
		{
			pgin[prgidx++] = ins_sub;
			continue;
		}
		if (c1 == 'M' && c2 == 'U' && c3 == 'L')
		{
			pgin[prgidx++] = ins_mul;
			continue;
		}
		if (c1 == 'D' && c2 == 'I' && c3 == 'V')
		{
			pgin[prgidx++] = ins_div;
			continue;
		}
		if (c1 == 'M' && c2 == 'O' && c3 == 'D')
		{
			pgin[prgidx++] = ins_mod;
			continue;
		}
		return ERR;
	}
}


int run_program(INT inp, INT *outp)
{
	int i;
	stack[0] = inp;
	stidx = 1;
	for (i = 0; i < prgidx; ++i)
	{
		if (pgin[i](pgval[i]))
		{
			return ERR_WRONG;
		}
	}
	if (stidx != 1)
	{
		return ERR_WRONG;
	}
	*outp = stack[0];
	return 0;
}

int read_quit() {
	if (getchar() != 'U')
		return ERR;
	if (getchar() != 'I')
		return ERR;
	if (getchar() != 'T')
		return ERR;
	if (read_end())
		return ERR;

	return (getchar() == EOF) ? 0 : ERR;
}

int main()
{
	for (;;)
	{
		int c, n;
		INT xin, xout, q;

		if ((c = getchar()) == 'Q')
		{
			if (read_quit())
			{
				return ERR;
			}
			return 0;
		}
		ungetc(c, stdin);
		n = read_program();
		if (n)
		{
			return n;
		}
		if (read_num(&q))
		{
			return ERR;
		}
		if (read_end())
		{
			return ERR;
		}
		if (q > MAX_QRYS)
		{

			return ERR_WRONG;
		}
		while (q-- > 0)
		{
			if (read_num(&xin))
			{
				return ERR;
			}
			if (read_end())
			{
				return ERR;
			}
			if (run_program(xin, &xout))
			{
				printf("ERROR\n");
			}
			else
			{
				printf("%d\n", xout);
			}
		}
		if (read_end())
		{
			return ERR;
		}
		printf("\n");
	}
}

# Shamir Secret

Simple command line Java implementation of the technique exposed in the paper "How to Share a Secret" by Adi Shamir (MIT November 1979). 

## Definition

Reference: [Shamir's Secret Sharing](https://en.wikipedia.org/wiki/Shamir%27s_Secret_Sharing)

It is a form of secret sharing, where a secret is divided into parts, giving each participant its own unique part, where some of the parts or all of them are needed in order to reconstruct the secret.

The goal is to divide ![D](http://latex.codecogs.com/gif.latex?D) (an integer number) into ![n](http://latex.codecogs.com/gif.latex?n) pieces of ![D1](http://latex.codecogs.com/gif.latex?D_{1})  ,...,![Dn](http://latex.codecogs.com/gif.latex?D_{n}) in shuch a way that:

- Knowledge of any ![k](http://latex.codecogs.com/gif.latex?k) or more ![Di](http://latex.codecogs.com/gif.latex?D_{i}) pieces makes _D_ easily computable
- Knowledge of any ![k-1](http://latex.codecogs.com/gif.latex?k-1) or fewer ![Di](http://latex.codecogs.com/gif.latex?D_{i}) pieces leaves ![D](http://latex.codecogs.com/gif.latex?D) completely undetermined 

This scheme is called a ![(k-n)](http://latex.codecogs.com/gif.latex?(k-n)) threshold scheme.

## Usage

Run with:
```shell
$ java -jar ShamirSecret.jar
```

__Menu__

* 1 to reveal a secret usign [Lagrange polynomial](https://en.wikipedia.org/wiki/Lagrange_polynomial) interpolation
* 2 to hide a secret and generate the ![n](http://latex.codecogs.com/gif.latex?n) points to share using the [Shamir's scheme](https://en.wikipedia.org/wiki/Shamir%27s_Secret_Sharing#Usage)
* 3 to quit

__Prime number__

[There](https://en.wikipedia.org/wiki/Shamir%27s_Secret_Sharing#Problem) is a security problem using integer arithmetic. A possible attacker gains a lot of information about ![D](http://latex.codecogs.com/gif.latex?D) with every ![Di](http://latex.codecogs.com/gif.latex?D_{i}) that he finds. To fix that, finite field arithmetic can be [used](https://en.wikipedia.org/wiki/Shamir%27s_Secret_Sharing#Solution). It just means that we should choose a prime ![p](http://latex.codecogs.com/gif.latex?p) that is bigger than the total of participants ![n](http://latex.codecogs.com/gif.latex?n) and the secret ![D](http://latex.codecogs.com/gif.latex?D). Thus we have to calculate the points as ![(x, f(x) mod p)](http://latex.codecogs.com/gif.latex?%28x,%20f%28x%29%20mod%20p%29) instead of ![(x, f(x))](http://latex.codecogs.com/gif.latex?%28x,%20f%28x%29%29).



## Capture

![](./capture.png)

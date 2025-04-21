# FrontEnd con ReactJS (Y Angular SOON!)

## Fundamentos de JavaScript que debes conocer

Antes de empezar con React, asegúrate de manejar lo siguiente:

- Variables y tipos: let, const, number, string, boolean, array, object.
- Funciones: funciones tradicionales y funciones flecha (() => {}).
- Desestructuración:

```javascript
const car = { brand: "Toyota", year: 2022 };
const { brand, year } = car;
```

- Array methods: .map(), .filter(), .reduce() son esenciales para renderizar listas en React.

- Import / Export:

```javascript
export default MiComponente;
import MiComponente from "./MiComponente";
```

## JSX

JSX es una sintaxis que te permite escribir HTML dentro de JavaScript. Por ejemplo:

```javascript
const element = <h1>¡Hola, mundo!</h1>;
```

JSX se compila a React.createElement, lo que significa que todo lo que escribas como HTML en React es realmente JavaScript.

[Rerencia: Introducción a JSX:](https://es.legacy.reactjs.org/docs/introducing-jsx.html)

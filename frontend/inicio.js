import React from 'react';
import ReactDOM from 'react-dom';
import './plantillaLetra.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
// Se hace la remocion del service worker para retornar una promesa en javascript.
serviceWorker.unregister();
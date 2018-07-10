import Vue from 'vue';
import {sharedState} from './store';
import './sass/main.scss';
import {Register} from './modules/pre-game/register/register';
import { createRouter } from './router';

// tslint:disable-next-line:no-unused-expression
new Vue({
    el: '#app-main',
    router: createRouter(),
    data: {
        sharedState
    }
});

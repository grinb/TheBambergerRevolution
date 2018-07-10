import Vue from 'vue';
import VueRouter from 'vue-router';
import {Register} from './modules/pre-game/register/register';
import {Countdown} from './modules/pre-game/countdown/countdown';

Vue.use(VueRouter);

export const createRoutes = () => [
    {
        path: '/',
        component: Register,
    },
    {
        path: '/countdown',
        component: Countdown,
    }
];

export const createRouter = () => new VueRouter({mode: 'history', routes: createRoutes()});

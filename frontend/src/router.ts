import Vue from 'vue';
import VueRouter from 'vue-router';
import {Register} from './modules/pre-game/register/register';
import {Countdown} from './modules/pre-game/countdown/countdown';
import {GameContainer} from './modules/game/GameContainer';

Vue.use(VueRouter);

export const createRoutes = () => [
    {
        path: '/',
        name: 'register',
        component: Register
    },
    {
        path: '/countdown',
        name: 'countdown',
        component: Countdown
    },
    {
        path: '/game',
        name: 'game',
        component: GameContainer
    }
];

export const createRouter = () => new VueRouter({mode: 'history', routes: createRoutes()});

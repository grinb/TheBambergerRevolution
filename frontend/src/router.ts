import Vue from 'vue';
import VueRouter from 'vue-router';
import {Register} from './modules/pre-game/register/register';

Vue.use(VueRouter);

export const createRoutes = () => [
    {
        path: '/',
        component: Register,
    }
];

export const createRouter = () => new VueRouter({mode: 'history', routes: createRoutes()});

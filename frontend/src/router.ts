import Vue from 'vue';
import VueRouter, { RouteConfig } from 'vue-router';
import {Register} from './modules/pre-game/register/register';

Vue.use(VueRouter);

export const createRoutes: () => RouteConfig[] = () => [
    {
        path: '/',
        component: Register,
    }
];

export const createRouter = () => new VueRouter({ mode: 'history', routes: createRoutes() });

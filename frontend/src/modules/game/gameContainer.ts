import {Vue, Component} from 'vue-property-decorator';
import {sharedState} from '../../store';
import { Score } from '../score/score';
import { Game } from './game';
import './game.scss';

@Component({
    template: require('./gameContainer.html'),
    components: {
        Score,
        Game
    }
})
export class GameContainer extends Vue {
    sharedState = sharedState;
}

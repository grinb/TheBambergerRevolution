import {Vue, Component} from 'vue-property-decorator';
import {sharedState} from '../../store';

@Component({
    template: require('./game.html'),
})
export class Game extends Vue {
    sharedState = sharedState;
}

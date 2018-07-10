import axios from 'axios';
import {Vue, Component} from 'vue-property-decorator';
import {sharedState} from '../../store';
import './score.scss';

@Component({
    template: require('./score.html')
})
export class Score extends Vue {
    sharedState = sharedState;
    interval;

    mounted() {
        sharedState.scores = [
            'Player 1', 'Player 4', 'Player 2', 'Player 5', 'Player 3'
        ];
        this.interval = setInterval(() => {
            this.loadScores();
        }, 5000);
    }

    destroy() {
        clearInterval(this.interval);
    }

    loadScores() {
        // axios.post()
    }
}

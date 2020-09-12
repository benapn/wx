import Rx from 'rxjs/Rx';
import {Injectable} from "@angular/core";
/**
 * Created by Ben on 08-Jul-17.
 */
@Injectable()
export class DataService {
  private socket: Rx.Subject<MessageEvent>;

  public connect(url): Rx.Subject<MessageEvent> {
    if (!this.socket){
      this.socket = this.create(url);
    }

    return this.socket;
  }

  private create(url): Rx.Subject<MessageEvent> {
    let ws = new WebSocket(url);

    let observable = Rx.Observable.create(
      (obs: Rx.Observer<MessageEvent>) => {
        ws.onmessage = obs.next.bind(obs);
        ws.onerror = obs.error.bind(obs);
        ws.onclose = obs.complete.bind(obs);

        return ws.close.bind(ws);
      });

    return Rx.Subject.create(observable);
  }
}

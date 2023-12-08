import {ChangeDetectorRef, Component, Input} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {EvaluationDTO} from "../../types/evaluation.types";
import {EvaluationService} from "../../services/evaluation.service";

@Component({
  selector: 'app-evaluation-detail',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './evaluation-detail.component.html',
  styleUrl: './evaluation-detail.component.css'
})
export class EvaluationDetailComponent {
  @Input() evaluation?: EvaluationDTO ;
  constructor(private readonly evaluationService: EvaluationService) {
  }

  deleteEval(id: number) {
    this.evaluationService.deleteEvaluation(id).subscribe();
  }
}

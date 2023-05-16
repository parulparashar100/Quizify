export interface Quiz {
    id: number;
	title: string;
	description: string;
	maxMarks: number;
	numberOfQuestions: number;
	isActive: boolean;
	categoryId: number;
}